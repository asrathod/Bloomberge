package com.progresssoft.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="valid_deal")
public class ValidDeals {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name ="id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="from_currency")
	private IsoCurrecncyCode fromCurrecncy;
	
	@ManyToOne
	@JoinColumn(name="to_currency")
	private IsoCurrecncyCode toCurrecncy;
	
	@Column(name ="amount")
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="file_name")
	private FileInfo fileInfo;
	
	@Column(name = "date")
	private Date date;
	
	public ValidDeals() {
		super();
	}

	public ValidDeals(long id) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public IsoCurrecncyCode getFromCurrecncy() {
		return fromCurrecncy;
	}

	public void setFromCurrecncy(IsoCurrecncyCode fromCurrecncy) {
		this.fromCurrecncy = fromCurrecncy;
	}

	public IsoCurrecncyCode getToCurrecncy() {
		return toCurrecncy;
	}

	public void setToCurrecncy(IsoCurrecncyCode toCurrecncy) {
		this.toCurrecncy = toCurrecncy;
	}

	public FileInfo getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}

	
}
