package com.progresssoft.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.progresssoft.bean.IsoCurrecncyCodeBean;
import com.progresssoft.dao.IsoCurrencyCodeDao;
import com.progresssoft.entity.IsoCurrecncyCode;
import com.progresssoft.util.HibernateUtil;

@Repository
public class IsoCurrencyCodeDaoImpl implements IsoCurrencyCodeDao {
	
	@Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public Map<String, IsoCurrecncyCodeBean> getAllIsoCurrencyCodes() {
		
		Session session = hibernateUtil.getCurrentSession();
		Query query = session.createQuery("FROM IsoCurrecncyCode)");			
		Map<String,IsoCurrecncyCodeBean> isoCurrecncyCodeBeanMap = getisoCurrecncyCodeBeanMap(query.list());
		
		return isoCurrecncyCodeBeanMap;		
	}

	private Map<String, IsoCurrecncyCodeBean> getisoCurrecncyCodeBeanMap(List<IsoCurrecncyCode> isoCurrecncyCode) {
		Map<String, IsoCurrecncyCodeBean> result = new HashMap<String, IsoCurrecncyCodeBean>();
		for(IsoCurrecncyCode isoCurrecncy : isoCurrecncyCode){
			IsoCurrecncyCodeBean isoCurrecncyCodeBean = convertEntityToBean(isoCurrecncy);
			result.put(isoCurrecncyCodeBean.getCurrencyCode(), isoCurrecncyCodeBean);
		}
		return result;
	}

	private IsoCurrecncyCodeBean convertEntityToBean(IsoCurrecncyCode isoCurrecncy) {
		IsoCurrecncyCodeBean isoCurrecncyCodeBeans = new IsoCurrecncyCodeBean();
		
		isoCurrecncyCodeBeans.setId(isoCurrecncy.getId());
		isoCurrecncyCodeBeans.setCountryName(isoCurrecncy.getCountryName());
		isoCurrecncyCodeBeans.setCurrencyCode(isoCurrecncy.getCurrencyCode());
		return isoCurrecncyCodeBeans;
	}

}
