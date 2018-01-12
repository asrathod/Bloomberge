package com.progresssoft.bean;

public class FileInfoBean {

	private long id;
	private String fileName;
	
	// Constructor
	public FileInfoBean() {
		
	}
	// Parameterized Constructor
	public FileInfoBean(long id) {
		this.id = id;
	}
	
	// Getters and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
