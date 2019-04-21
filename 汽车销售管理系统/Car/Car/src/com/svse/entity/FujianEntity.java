package com.svse.entity;

import java.io.Serializable;

public class FujianEntity implements Serializable {
	private int fjid;
	private int caroutmxid;
	private int inhandoutid;
	private int zscount;
	private String customname;
	private String customtel;
	private String handoutname;
	private String carouttime;
	private String mrealname;
	
	
	
	public String getMrealname() {
		return mrealname;
	}
	public void setMrealname(String mrealname) {
		this.mrealname = mrealname;
	}
	public String getCarouttime() {
		return carouttime;
	}
	public void setCarouttime(String carouttime) {
		this.carouttime = carouttime;
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
	public String getHandoutname() {
		return handoutname;
	}
	public void setHandoutname(String handoutname) {
		this.handoutname = handoutname;
	}
	public int getFjid() {
		return fjid;
	}
	public void setFjid(int fjid) {
		this.fjid = fjid;
	}
	public int getCaroutmxid() {
		return caroutmxid;
	}
	public void setCaroutmxid(int caroutmxid) {
		this.caroutmxid = caroutmxid;
	}
	public int getInhandoutid() {
		return inhandoutid;
	}
	public void setInhandoutid(int inhandoutid) {
		this.inhandoutid = inhandoutid;
	}
	public int getZscount() {
		return zscount;
	}
	public void setZscount(int zscount) {
		this.zscount = zscount;
	}
	
	
	
	
}
