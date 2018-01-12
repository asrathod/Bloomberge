package com.progresssoft.bean;

public class AccumulativeCountBean {

	private long id;
	private long isoCurrencyCodeId;
	private String isoCurrencyCountryName;
	private String isoCurrencyCodeName;
	private int count;
	
	// Constructor
	public AccumulativeCountBean() {
		
	}

	// Parameterized Constructor
	public AccumulativeCountBean(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIsoCurrencyCodeId() {
		return isoCurrencyCodeId;
	}

	public void setIsoCurrencyCodeId(long isoCurrencyCodeId) {
		this.isoCurrencyCodeId = isoCurrencyCodeId;
	}

	public String getIsoCurrencyCountryName() {
		return isoCurrencyCountryName;
	}

	public void setIsoCurrencyCountryName(String isoCurrencyCountryName) {
		this.isoCurrencyCountryName = isoCurrencyCountryName;
	}

	public String getIsoCurrencyCodeName() {
		return isoCurrencyCodeName;
	}

	public void setIsoCurrencyCodeName(String isoCurrencyCodeName) {
		this.isoCurrencyCodeName = isoCurrencyCodeName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
