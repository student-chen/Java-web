package com.svse.entity;

public class PurchaseEntity {
	
	private int purchaseid;
	private int mid;
	private String purtitle;
	private String purremark;
	private int pmoney;
	private String ptime;
	private int purchaseflag;
	private int sugid;
	private String suggestion;
	
	private String deptname;
	private String mname;
	private String mrealname;
	private String flag;
	
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMrealname() {
		return mrealname;
	}

	public void setMrealname(String mrealname) {
		this.mrealname = mrealname;
	}

	private MasterEntity master=new MasterEntity();

	public int getPurchaseid() {
		return purchaseid;
	}

	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getPurtitle() {
		return purtitle;
	}

	public void setPurtitle(String purtitle) {
		this.purtitle = purtitle;
	}

	public String getPurremark() {
		return purremark;
	}

	public void setPurremark(String purremark) {
		this.purremark = purremark;
	}

	public int getPmoney() {
		return pmoney;
	}

	public void setPmoney(int pmoney) {
		this.pmoney = pmoney;
	}

	public String getPtime() {
		return ptime;
	}

	public void setPtime(String ptime) {
		this.ptime = ptime;
	}

	public int getPurchaseflag() {
		return purchaseflag;
	}

	public void setPurchaseflag(int purchaseflag) {
		this.purchaseflag = purchaseflag;
	}

	public int getSugid() {
		return sugid;
	}

	public void setSugid(int sugid) {
		this.sugid = sugid;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public MasterEntity getMaster() {
		return master;
	}

	public void setMaster(MasterEntity master) {
		this.master = master;
	}
	
}
