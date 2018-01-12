package com.progresssoft.dao;

import com.progresssoft.bean.AccumulativeCountBean;

public interface AccumulativeCountDao {

	public long createNewAccumulativeCount(AccumulativeCountBean cccumulativeCountBean);
	public AccumulativeCountBean getAccumulativeCountByIsoCurrencyCode(long isoCurrencyCodeId);
	public AccumulativeCountBean updateAccumulativeCount(AccumulativeCountBean cccumulativeCountBean);

}
