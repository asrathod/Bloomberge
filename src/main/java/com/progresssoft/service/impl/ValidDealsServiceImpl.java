package com.progresssoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progresssoft.bean.ValidDealsBean;
import com.progresssoft.dao.ValidDealsDao;
import com.progresssoft.service.ValidDealsService;

@Service
@Transactional
public class ValidDealsServiceImpl implements ValidDealsService {
	
	@Autowired
    private ValidDealsDao validDealsDao;

	@Override
	public long createNewValidDeal(ValidDealsBean validDealsBean) {
		
		return validDealsDao.createNewValidDeal(validDealsBean);
	}

	@Override
	public ValidDealsBean getValidDealsByFileId(long fileId) {
		
		return validDealsDao.getValidDealsByFileId(fileId);
	}

	@Override
	public List<ValidDealsBean> getAllValidDealsByFileId(long fileId) {
		
		return validDealsDao.getAllValidDealsByFileId(fileId);
	}

}
