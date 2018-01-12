package com.progresssoft.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.progresssoft.bean.ValidDealsBean;
import com.progresssoft.dao.ValidDealsDao;
import com.progresssoft.entity.FileInfo;
import com.progresssoft.entity.IsoCurrecncyCode;
import com.progresssoft.entity.ValidDeals;
import com.progresssoft.util.HibernateUtil;

@Repository
public class ValidDealsDaoImpl implements ValidDealsDao {
	
	@Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public long createNewValidDeal(ValidDealsBean validDealsBean) {
		ValidDeals validDeals = convertBeanToEntity(validDealsBean);	
		return (Long) hibernateUtil.create(validDeals);
	}

	@Override
	public ValidDealsBean getValidDealsByFileId(long fileId) {	
		ValidDeals validDeals = hibernateUtil.fetchById(fileId, ValidDeals.class);
		return convertEntityToBean(validDeals);		
	}

	@Override
	public List<ValidDealsBean> getAllValidDealsByFileId(long fileId) {
		Session session = hibernateUtil.getCurrentSession();
		Query query = session.createQuery("FROM ValidDeals as vd WHERE vd.fileInfo.id=:fileId");
		query.setParameter("fileId", fileId);
		List<ValidDealsBean> validDealsBean = getValidDeals(query.list());
		return validDealsBean;
	}

	private List<ValidDealsBean> getValidDeals(List<ValidDeals> validDealsList) {
		List<ValidDealsBean> validDealsBeans = new ArrayList<ValidDealsBean>();
		for(ValidDeals validDeals : validDealsList){
			ValidDealsBean validDealsBean = convertEntityToBean(validDeals);
			validDealsBeans.add(validDealsBean);
		}
		return validDealsBeans;
	}


	//To convert bean to entity
	private ValidDeals convertBeanToEntity(ValidDealsBean validDealsBean) {
		ValidDeals validDeals = new ValidDeals();
		validDeals.setId(validDealsBean.getId());
		validDeals.setFromCurrecncy(new IsoCurrecncyCode(validDealsBean.getFromCurrecncy()));
		validDeals.setToCurrecncy(new IsoCurrecncyCode(validDealsBean.getToCurrecncy()));
		validDeals.setAmount(validDealsBean.getAmount());
		validDeals.setDate(validDealsBean.getDate());
		validDeals.setFileInfo(new FileInfo(validDealsBean.getFileId()));
		return validDeals;
	}

	//To convert entity to bean
	private ValidDealsBean convertEntityToBean(ValidDeals validDeals) {
		ValidDealsBean validDealsBean = new ValidDealsBean();
		validDealsBean.setId(validDeals.getId());
		validDealsBean.setFromCurrecncy(validDeals.getFromCurrecncy().getId());
		validDealsBean.setToCurrecncy(validDeals.getToCurrecncy().getId());
		validDealsBean.setAmount(validDeals.getAmount());
		validDealsBean.setFileId(validDeals.getFileInfo().getId());
		validDealsBean.setDate(validDeals.getDate());
		
		return validDealsBean;
	}
}
