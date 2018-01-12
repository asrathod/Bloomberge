package com.progresssoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="iso_currency_code")
public class IsoCurrecncyCode {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="id")
	private long id;
	
	@Column(name ="country_name")
	private String countryName;
	
	@Column(name = "currency_code")
	private String currencyCode;

	// Constructor
	public IsoCurrecncyCode() {
		
	}
	// Parameterized Constructor
	public IsoCurrecncyCode(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
}
