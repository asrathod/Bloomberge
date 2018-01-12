package com.progresssoft.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progresssoft.bean.IsoCurrecncyCodeBean;
import com.progresssoft.dao.IsoCurrencyCodeDao;
import com.progresssoft.service.IsoCurrencyCodeService;

@Service
@Transactional
public class IsoCurrencyCodeServiceImpl implements IsoCurrencyCodeService {
	
	@Autowired
    private IsoCurrencyCodeDao isoCurrencyCodeDao;

	@Override
	public Map<String, IsoCurrecncyCodeBean> getAllIsoCurrencyCodes() {
		
		return isoCurrencyCodeDao.getAllIsoCurrencyCodes();
	}

}
