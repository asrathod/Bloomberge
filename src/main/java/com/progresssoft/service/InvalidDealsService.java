package com.progresssoft.service;

import java.util.List;

import com.progresssoft.bean.InvalidDealsBean;

public interface InvalidDealsService {

	public long createNewInvalidDeal(InvalidDealsBean invalidDealsBean);
	public InvalidDealsBean getInvalidDealsByFileId(long fileId);
	public List<InvalidDealsBean> getAllInvalidDealsByFileId(long fileId);
}
