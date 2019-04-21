package com.svse.entity;

import java.io.Serializable;

public class CustomEntity implements Serializable {
	
	private int customid;
	private int mid;
	private String customname;
	private String customtel;
	private String mname;
	private String mrealname;
	
	
	
	public String getMrealname() {
		return mrealname;
	}
	public void setMrealname(String mrealname) {
		this.mrealname = mrealname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
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
	public String getCustomname() {
		return customname;
	}
	public void setCustomname(String customname) {
		this.customname = customname;
	}
	public String getCustomtel() {
		return customtel;
	}
	public void setCustomtel(String customtel) {
		this.customtel = customtel;
	}
	
	
	
}
