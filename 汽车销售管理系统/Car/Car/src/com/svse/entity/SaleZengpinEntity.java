package com.svse.entity;

import java.io.Serializable;

public class SaleZengpinEntity implements Serializable {
	private int salezpid;
	private int inhandoutid;
	private String kehuname;
	private String kehutel;
	private int salecount;
	
	private String saletime;
	private int mid;
	private String saleremark;
	private String mrealname;
	private String handoutname;
	
	
	public String getHandoutname() {
		return handoutname;
	}
	public void setHandoutname(String handoutname) {
		this.handoutname = handoutname;
	}
	public String getMrealname() {
		return mrealname;
	}
	public void setMrealname(String mrealname) {
		this.mrealname = mrealname;
	}
	public int getSalezpid() {
		return salezpid;
	}
	public void setSalezpid(int salezpid) {
		this.salezpid = salezpid;
	}
	public int getInhandoutid() {
		return inhandoutid;
	}
	public void setInhandoutid(int inhandoutid) {
		this.inhandoutid = inhandoutid;
	}
	
	public String getKehuname() {
		return kehuname;
	}
	public void setKehuname(String kehuname) {
		this.kehuname = kehuname;
	}
	public String getKehutel() {
		return kehutel;
	}
	public void setKehutel(String kehutel) {
		this.kehutel = kehutel;
	}
	public int getSalecount() {
		return salecount;
	}
	public void setSalecount(int salecount) {
		this.salecount = salecount;
	}
	public String getSaletime() {
		return saletime;
	}
	public void setSaletime(String saletime) {
		this.saletime = saletime;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getSaleremark() {
		return saleremark;
	}
	public void setSaleremark(String saleremark) {
		this.saleremark = saleremark;
	}
	
	
	
	
}
