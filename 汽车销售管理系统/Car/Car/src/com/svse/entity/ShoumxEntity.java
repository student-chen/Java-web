package com.svse.entity;

import java.io.Serializable;

public class ShoumxEntity implements Serializable {
	private int shouhoumxid;
	private int shouhouid;
	private String fwnr;
	private int shouhouflag;
	private String flag;
	private String shmoney;
	private String shtime;
	private int mid;
	private String mrealname;
	private String customname;
	
	
	public String getCustomname() {
		return customname;
	}
	public void setCustomname(String customname) {
		this.customname = customname;
	}
	public int getShouhoumxid() {
		return shouhoumxid;
	}
	public void setShouhoumxid(int shouhoumxid) {
		this.shouhoumxid = shouhoumxid;
	}
	public int getShouhouid() {
		return shouhouid;
	}
	public void setShouhouid(int shouhouid) {
		this.shouhouid = shouhouid;
	}
	public String getFwnr() {
		return fwnr;
	}
	public void setFwnr(String fwnr) {
		this.fwnr = fwnr;
	}
	public int getShouhouflag() {
		return shouhouflag;
	}
	public void setShouhouflag(int shouhouflag) {
		this.shouhouflag = shouhouflag;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getShmoney() {
		return shmoney;
	}
	public void setShmoney(String shmoney) {
		this.shmoney = shmoney;
	}
	public String getShtime() {
		return shtime;
	}
	public void setShtime(String shtime) {
		this.shtime = shtime;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMrealname() {
		return mrealname;
	}
	public void setMrealname(String mrealname) {
		this.mrealname = mrealname;
	}
	
	
	
}
