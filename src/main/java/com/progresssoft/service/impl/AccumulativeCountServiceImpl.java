package com.progresssoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progresssoft.bean.AccumulativeCountBean;
import com.progresssoft.dao.AccumulativeCountDao;
import com.progresssoft.service.AccumulativeCountService;

@Service
@Transactional
public class AccumulativeCountServiceImpl implements AccumulativeCountService {

	@Autowired
    private AccumulativeCountDao accumulativeCountDao;
	
	@Override
	public long createNewAccumulativeCount(AccumulativeCountBean accumulativeCountBean) {
		return accumulativeCountDao.createNewAccumulativeCount(accumulativeCountBean);
	}

	@Override
	public AccumulativeCountBean getAccumulativeCountByIsoCurrencyCode(long isoCurrencyCodeId) {
		return accumulativeCountDao.getAccumulativeCountByIsoCurrencyCode(isoCurrencyCodeId);
	}

	@Override
	public AccumulativeCountBean updateAccumulativeCount(AccumulativeCountBean accumulativeCountBean) {
		return accumulativeCountDao.updateAccumulativeCount(accumulativeCountBean);
	}

}
