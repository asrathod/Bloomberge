package com.progresssoft.dao;

import java.util.List;

import com.progresssoft.bean.InvalidDealsBean;

public interface InvalidDealsDao {

	public long createNewInvalidDeal(InvalidDealsBean invalidDealsBean);
	public InvalidDealsBean getInvalidDealsByFileId(long fileId);
	public List<InvalidDealsBean> getAllInvalidDealsByFileId(long fileId);
}
