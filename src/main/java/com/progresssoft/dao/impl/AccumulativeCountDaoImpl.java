package com.progresssoft.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.progresssoft.bean.AccumulativeCountBean;
import com.progresssoft.dao.AccumulativeCountDao;
import com.progresssoft.entity.AccumulativeCount;
import com.progresssoft.entity.IsoCurrecncyCode;
import com.progresssoft.util.HibernateUtil;

@Repository
public class AccumulativeCountDaoImpl implements AccumulativeCountDao{

	@Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public long createNewAccumulativeCount(AccumulativeCountBean accumulativeCountBean) {
		AccumulativeCount accumulativeCount = convertBeanToEntity(accumulativeCountBean);
		return (Long) hibernateUtil.create(accumulativeCount);
	}

	@Override
	public AccumulativeCountBean getAccumulativeCountByIsoCurrencyCode(long isoCurrencyCodeId) {
		Session session = hibernateUtil.getCurrentSession();
		Query query = session.createQuery("FROM AccumulativeCount as ac WHERE ac.isoCurrencyCode.id =:isoCurrencyCodeId");
		query.setParameter("isoCurrencyCodeId", isoCurrencyCodeId);
		AccumulativeCount accumulativeCount = (AccumulativeCount) query.uniqueResult();
		if(accumulativeCount == null){
			return null;
		}else{
			return convertEntityToBean(accumulativeCount);
		}
	}

	@Override
	public AccumulativeCountBean updateAccumulativeCount(AccumulativeCountBean accumulativeCountBean) {
		AccumulativeCount accumulativeCount = convertBeanToEntity(accumulativeCountBean);
		return convertEntityToBean((AccumulativeCount) hibernateUtil.update(accumulativeCount));
		
	}

	private AccumulativeCountBean convertEntityToBean(AccumulativeCount accumulativeCount){
	
		AccumulativeCountBean accumulativeCountBean = new AccumulativeCountBean();
		
		accumulativeCountBean.setId(accumulativeCount.getId());
		accumulativeCountBean.setCount(accumulativeCount.getCount());
	
		accumulativeCountBean.setIsoCurrencyCodeId(accumulativeCount.getIsoCurrencyCode().getId());
		accumulativeCountBean.setIsoCurrencyCodeName(accumulativeCount.getIsoCurrencyCode().getCurrencyCode());
		accumulativeCountBean.setIsoCurrencyCountryName(accumulativeCount.getIsoCurrencyCode().getCountryName());;
		return accumulativeCountBean;
		
	}
	
	private AccumulativeCount convertBeanToEntity(AccumulativeCountBean accumulativeCountBean){
	
		AccumulativeCount accumulativeCount = new AccumulativeCount();
		
		accumulativeCount.setId(accumulativeCountBean.getId());
		accumulativeCount.setCount(accumulativeCountBean.getCount());
		accumulativeCount.setIsoCurrencyCode(new IsoCurrecncyCode(accumulativeCountBean.getIsoCurrencyCodeId()));
		
		return accumulativeCount;
		
	}
	
    
}
