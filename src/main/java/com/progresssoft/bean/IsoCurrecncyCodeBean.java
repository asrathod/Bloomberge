package com.progresssoft.bean;

public class IsoCurrecncyCodeBean {

	private long id;
	private String countryName;
	private String currencyCode;
	
	
	// Constructor
	public IsoCurrecncyCodeBean() {
	
	}
	// Parameterized Constructor
	public IsoCurrecncyCodeBean(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
