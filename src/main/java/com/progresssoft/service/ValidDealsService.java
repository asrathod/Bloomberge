package com.progresssoft.service;

import java.util.List;

import com.progresssoft.bean.ValidDealsBean;

public interface ValidDealsService {

	public long createNewValidDeal(ValidDealsBean validDealsBean);
	public ValidDealsBean getValidDealsByFileId(long fileId);
	public List<ValidDealsBean> getAllValidDealsByFileId(long fileId);
}
