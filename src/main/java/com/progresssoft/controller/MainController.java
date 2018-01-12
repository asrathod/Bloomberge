package com.progresssoft.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.progresssoft.bean.AccumulativeCountBean;
import com.progresssoft.bean.FileInfoBean;
import com.progresssoft.bean.InvalidDealsBean;
import com.progresssoft.bean.IsoCurrecncyCodeBean;
import com.progresssoft.bean.ValidDealsBean;
import com.progresssoft.service.AccumulativeCountService;
import com.progresssoft.service.FileInfoService;
import com.progresssoft.service.InvalidDealsService;
import com.progresssoft.service.IsoCurrencyCodeService;
import com.progresssoft.service.ValidDealsService;

import au.com.bytecode.opencsv.CSVReader;

@Controller
@RequestMapping("/")
public class MainController {

	private final Logger LOGGER = Logger.getLogger(getClass());
	private static final String REDIRECT_VALID_INVALID_DEALS_LIST = "redirect:listValidAndInvalidDeals";
	private static final String REDIRECT_INVALID_DEALS_LIST = "redirect:invalidDeals";
	
	@Autowired
    private FileInfoService fileInfoService; 
	
	@Autowired
    private ValidDealsService validDealsService;
	
	@Autowired
    private InvalidDealsService invalidDealsService;
	
	@Autowired
	private IsoCurrencyCodeService isoCurrencyCodeService;
	
	@Autowired
	private AccumulativeCountService accumulativeCountService;
	
	
	@RequestMapping(value = "/fileUploadPage", method = RequestMethod.GET)
	public String fileUploadPage(HttpServletRequest request, Model model){
	
	//	return "fileUpload";
		return "infoFile";
		
	}
	
	@RequestMapping(value = "saveFileData", method = RequestMethod.POST)
	public String saveFileData(@RequestParam("file") MultipartFile uploadedFile, HttpServletRequest request, Model model, 
			RedirectAttributes redirectAttributes) throws IOException{
	
		String fileName = uploadedFile.getOriginalFilename();
		
		FileInfoBean fileInfoBean=fileInfoService.getFileByName(fileName);
		
		
	//	File myFile =new File(uploadFiles.getOriginalFilename());
			
		if(fileInfoBean == null){
			long fileId = fileInfoService.createNewFile(fileName);
			Map<String,IsoCurrecncyCodeBean> currencyCodeMap = isoCurrencyCodeService.getAllIsoCurrencyCodes();
			
			File file = convert(uploadedFile);
			CSVReader reader = new CSVReader(new FileReader(file),',');
			List<String[]> records = reader.readAll();
			Iterator<String[]> iterator = records.iterator();
			
			while(iterator.hasNext()){
				Boolean validDeal = true;
				StringBuffer invalidMessage = new StringBuffer();
				String[] record = iterator.next();
				
				if( record[1].isEmpty() || ! currencyCodeMap.containsKey(record[1])){
					validDeal = false;
					invalidMessage.append(" Invalid From ISO Currency Code ");
				}
				if( record[2].isEmpty() || ! currencyCodeMap.containsKey(record[2])){
					validDeal = false;
					invalidMessage.append(" Invalid To ISO Currency Code ");
				}
				
				if( record[3].isEmpty() || ! isValidDate(record[3])){
					validDeal = false;
					invalidMessage.append(" Invalid Date");
				}
				if( record[4].isEmpty() ||  ! isValidAmount(record[4])){
					validDeal = false;
					invalidMessage.append(" Invalid Amount");
				}
				
				
				if(validDeal == true){
					ValidDealsBean validDealsBean = new ValidDealsBean();
					validDealsBean.setFileId(fileId);
					validDealsBean.setFromCurrecncy(currencyCodeMap.get(record[1]).getId());
					validDealsBean.setToCurrecncy(currencyCodeMap.get(record[2]).getId());
					validDealsBean.setDate(convertStringToDate(record[3]));
					validDealsBean.setAmount(Double.valueOf(record[4]));
					
					validDealsService.createNewValidDeal(validDealsBean);
					redirectAttributes.addFlashAttribute("message", "Valid deals are created successfully!");
					//increase count of toCurrancy code in accumulative_count_table
					
					AccumulativeCountBean accumulativeCountBean = accumulativeCountService.getAccumulativeCountByIsoCurrencyCode(currencyCodeMap.get(record[2]).getId());
					if(accumulativeCountBean == null){
						AccumulativeCountBean newAccumulativeCountBean = new AccumulativeCountBean();
						newAccumulativeCountBean.setCount(1);
						newAccumulativeCountBean.setIsoCurrencyCodeId(currencyCodeMap.get(record[2]).getId());
						accumulativeCountService.createNewAccumulativeCount(newAccumulativeCountBean);
					}else{
						//increase count by 1
						accumulativeCountBean.setCount(accumulativeCountBean.getCount()+1);
						accumulativeCountService.updateAccumulativeCount(accumulativeCountBean);
					}
					
				}else{
					InvalidDealsBean invalidDealsBean = new InvalidDealsBean();
					
					invalidDealsBean.setFileId(fileId);
					invalidDealsBean.setToCurrecncy(record[2]);
					invalidDealsBean.setFromCurrecncy(record[1]);
					invalidDealsBean.setDate(record[3]);
					invalidDealsBean.setAmount(record[4]);
					invalidDealsBean.setReason(invalidMessage.toString());
					
					invalidDealsService.createNewInvalidDeal(invalidDealsBean);		
 				}
				
			}
			reader.close();
							
		}else{
			//  File Already Exist Error message
			redirectAttributes.addFlashAttribute("error", "File is Already Exist");
			return "infoFile";
		}
		return REDIRECT_VALID_INVALID_DEALS_LIST;
	//	return null ;
	}
	
	// multipart file code
	public static File convert(MultipartFile file) throws IOException {
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile();
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;
	}

	static public boolean isValidDate(String inDate) {
		if (inDate == null)
			return false;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		if (inDate.trim().length() != dateFormat.toPattern().length())
			return false;

		dateFormat.setLenient(false);

		try {
			dateFormat.parse(inDate.trim());
		}
		catch (ParseException pe) {
			return false;
		}
		return true;
	}

	// validate date
	static public Date convertStringToDate(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date date =  dateFormat.parse(dateString.trim());
			return date;
		}
		catch (ParseException pe) {
			return null;
		}

	}
	
	// validate amount
	static public boolean isValidAmount(String amount){
		
		try
		{
		  Double.parseDouble(amount);
		  return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}

	}
	
	@RequestMapping(value ="listValidAndInvalidDeals", method = RequestMethod.GET)
	public String getAllValidAndInvalid(Model model, @RequestParam(value="fileId", defaultValue="-1", required=false) long fileId) {
	
			model.addAttribute("fileList", fileInfoService.getAllFiles());
			
			if(fileId != 0){
				model.addAttribute("validDealsList", validDealsService.getAllValidDealsByFileId(fileId));
				model.addAttribute("invalidDealsList", invalidDealsService.getAllInvalidDealsByFileId(fileId));
			}
		
		return "listValidAndInvalidDeals";
	}
	
}
