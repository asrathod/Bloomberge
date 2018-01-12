package com.progresssoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progresssoft.bean.InvalidDealsBean;
import com.progresssoft.dao.InvalidDealsDao;
import com.progresssoft.service.InvalidDealsService;

@Service
@Transactional
public class InvalidDealsServiceImpl implements InvalidDealsService {

	@Autowired
    private InvalidDealsDao invalidDealsDao;
    
	@Override
	public long createNewInvalidDeal(InvalidDealsBean invalidDealsBean) {
		
		return invalidDealsDao.createNewInvalidDeal(invalidDealsBean);
	}

	@Override
	public InvalidDealsBean getInvalidDealsByFileId(long fileId) {
		
		return invalidDealsDao.getInvalidDealsByFileId(fileId);
	}

	@Override
	public List<InvalidDealsBean> getAllInvalidDealsByFileId(long fileId) {
		
		return invalidDealsDao.getAllInvalidDealsByFileId(fileId);
	}

}
