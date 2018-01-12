package com.progresssoft.dao;

import java.util.List;

import com.progresssoft.bean.ValidDealsBean;

public interface ValidDealsDao {

	public long createNewValidDeal(ValidDealsBean validDealsBean);
	public ValidDealsBean getValidDealsByFileId(long fileId);
	public List<ValidDealsBean> getAllValidDealsByFileId(long fileId);
	
}
