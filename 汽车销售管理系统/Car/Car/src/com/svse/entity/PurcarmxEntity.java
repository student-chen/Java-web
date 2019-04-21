package com.svse.entity;

import java.io.Serializable;

public class PurcarmxEntity implements Serializable {
	
	private int pmxid;
	private int purchaseid;
	private int detailid;
	private int caigouprice;
	private int caigoucount;
	private int purchaseflag;
	private String sortname;
	private String detailname;
	private String detailguige;
	

	private PurchaseEntity purchase =new PurchaseEntity();
	private CardetailEntity cardetail =new CardetailEntity();
	
	
	
	
	public int getPurchaseflag() {
		return purchaseflag;
	}

	public void setPurchaseflag(int purchaseflag) {
		this.purchaseflag = purchaseflag;
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

	public String getDetailguige() {
		return detailguige;
	}

	public void setDetailguige(String detailguige) {
		this.detailguige = detailguige;
	}

	public CardetailEntity getCardetail() {
		return cardetail;
	}

	public void setCardetail(CardetailEntity cardetail) {
		this.cardetail = cardetail;
	}

	public int getPmxid() {
		return pmxid;
	}

	public void setPmxid(int pmxid) {
		this.pmxid = pmxid;
	}

	public int getPurchaseid() {
		return purchaseid;
	}

	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}

	public int getDetailid() {
		return detailid;
	}

	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}

	public int getCaigouprice() {
		return caigouprice;
	}

	public void setCaigouprice(int caigouprice) {
		this.caigouprice = caigouprice;
	}

	public int getCaigoucount() {
		return caigoucount;
	}

	public void setCaigoucount(int caigoucount) {
		this.caigoucount = caigoucount;
	}

	public PurchaseEntity getPurchase() {
		return purchase;
	}

	public void setPurchase(PurchaseEntity purchase) {
		this.purchase = purchase;
	}
	
	
	
	
}
