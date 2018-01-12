package com.progresssoft.bean;

import java.util.Date;

public class ValidDealsBean {

	private long id;
	private long fromCurrecncy;
	private long toCurrecncy;
	private double amount;
	private String fileName;
	private long fileId;
	private Date date;
	
	// Constructor
	public ValidDealsBean() {

	}
	// Parameterized Constructor
	public ValidDealsBean(long id) {
		this.id = id;
	}
	
	// Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getFromCurrecncy() {
		return fromCurrecncy;
	}
	public void setFromCurrecncy(long fromCurrecncy) {
		this.fromCurrecncy = fromCurrecncy;
	}
	public long getToCurrecncy() {
		return toCurrecncy;
	}
	public void setToCurrecncy(long toCurrecncy) {
		this.toCurrecncy = toCurrecncy;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getFileId() {
		return fileId;
	}
	public void setFileId(long fileId) {
		this.fileId = fileId;
	}
	
}
