package com.svse.entity;

import java.io.Serializable;

public class CaroutmxEntity implements Serializable {
	
	private int caroutmxid;
	private int incarmxid;
	private int customid;
	private int mid;
	private String carouttime;
	private String caroutremark;
	private int sortid;
	private String sortname;
	private String detailname;
	private int m;
	private String mrealname;
	
	
	public String getMrealname() {
		return mrealname;
	}
	public void setMrealname(String mrealname) {
		this.mrealname = mrealname;
	}
	public int getSortid() {
		return sortid;
	}
	public void setSortid(int sortid) {
		this.sortid = sortid;
	}
	
	public String getSortname() {
		return sortname;
	}
	public void setSortname(String sortname) {
		this.sortname = sortname;
	}
	public String getDetailname() {
		return detailname;
	}
	public void setDetailname(String detailname) {
		this.detailname = detailname;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public int getCaroutmxid() {
		return caroutmxid;
	}
	public void setCaroutmxid(int caroutmxid) {
		this.caroutmxid = caroutmxid;
	}
	public int getIncarmxid() {
		return incarmxid;
	}
	public void setIncarmxid(int incarmxid) {
		this.incarmxid = incarmxid;
	}
	public int getCustomid() {
		return customid;
	}
	public void setCustomid(int customid) {
		this.customid = customid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getCarouttime() {
		return carouttime;
	}
	public void setCarouttime(String carouttime) {
		this.carouttime = carouttime;
	}
	public String getCaroutremark() {
		return caroutremark;
	}
	public void setCaroutremark(String caroutremark) {
		this.caroutremark = caroutremark;
	}
	
	
	
	
}
