package com.progresssoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="file_info")
public class FileInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="id")
	private long id;
	
	@Column(name ="file_name")
	private String fileName;

	// Constructor
	public FileInfo() {
		
	}
	// Constructor
	public FileInfo(long id) {
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
