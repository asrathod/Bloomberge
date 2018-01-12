package com.progresssoft.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.progresssoft.bean.InvalidDealsBean;
import com.progresssoft.dao.InvalidDealsDao;
import com.progresssoft.entity.FileInfo;
import com.progresssoft.entity.InvalidDeals;
import com.progresssoft.util.HibernateUtil;

@Repository
public class InvalidDealsDaoImpl implements InvalidDealsDao {
	
	@Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public long createNewInvalidDeal(InvalidDealsBean invalidDealsBean) {
		InvalidDeals invalidDeals = convertBeanToEntity(invalidDealsBean);	
		return (Long) hibernateUtil.create(invalidDeals);
	}

	@Override
	public InvalidDealsBean getInvalidDealsByFileId(long fileId) {
		InvalidDeals invalidDeals = hibernateUtil.fetchById(fileId, InvalidDeals.class);
		return convertEntityToBean(invalidDeals);	
	}

	@Override
	public List<InvalidDealsBean> getAllInvalidDealsByFileId(long fileId) {
		Session session = hibernateUtil.getCurrentSession();
		Query query = session.createQuery("FROM InvalidDeals as ivd WHERE ivd.fileInfo.id=:fileId");
		query.setParameter("fileId", fileId);
		List<InvalidDealsBean> invalidDealsBean = getInvalidDeals(query.list());
		return invalidDealsBean;
		
	}

	private List<InvalidDealsBean> getInvalidDeals(List<InvalidDeals> invalidDealsList) {
		List<InvalidDealsBean> invalidDealsBeans = new ArrayList<InvalidDealsBean>();
		for(InvalidDeals invalidDeals : invalidDealsList){
			InvalidDealsBean invalidDealsBean = convertEntityToBean(invalidDeals);
			invalidDealsBeans.add(invalidDealsBean);
		}
		return invalidDealsBeans ;
	}

	//To convert bean to entity
	private InvalidDeals convertBeanToEntity(InvalidDealsBean invalidDealsBean) {
		InvalidDeals invalidDeals = new InvalidDeals();
		invalidDeals.setId(invalidDealsBean.getId());
		invalidDeals.setFromCurrecncy(invalidDealsBean.getFromCurrecncy());
		invalidDeals.setToCurrecncy(invalidDealsBean.getToCurrecncy());
		invalidDeals.setAmount(invalidDealsBean.getAmount());
		invalidDeals.setDate(invalidDealsBean.getDate());
		invalidDeals.setFileInfo(new FileInfo(invalidDealsBean.getFileId()));
		invalidDeals.setReason(invalidDealsBean.getReason());
		
		return invalidDeals;
	}
	
	//To convert entity to bean
	private InvalidDealsBean convertEntityToBean(InvalidDeals invalidDeals) {
		InvalidDealsBean invalidDealsBean = new InvalidDealsBean();
		invalidDealsBean.setId(invalidDeals.getId());
		invalidDealsBean.setFromCurrecncy(invalidDeals.getFromCurrecncy());
		invalidDealsBean.setToCurrecncy(invalidDeals.getToCurrecncy());
		invalidDealsBean.setAmount(invalidDeals.getAmount());
		invalidDealsBean.setDate(invalidDeals.getDate());
		invalidDealsBean.setFileId(invalidDeals.getFileInfo().getId());
		invalidDealsBean.setReason(invalidDeals.getReason());
		
		return invalidDealsBean;
	}

}
