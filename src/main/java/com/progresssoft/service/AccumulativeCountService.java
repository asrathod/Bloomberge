package com.progresssoft.service;

import com.progresssoft.bean.AccumulativeCountBean;

public interface AccumulativeCountService {
	
	public long createNewAccumulativeCount(AccumulativeCountBean accumulativeCountBean);
	public AccumulativeCountBean getAccumulativeCountByIsoCurrencyCode(long isoCurrencyCodeId);
	public AccumulativeCountBean updateAccumulativeCount(AccumulativeCountBean accumulativeCountBean);

}
