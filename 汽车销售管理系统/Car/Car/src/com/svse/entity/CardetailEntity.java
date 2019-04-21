package com.svse.entity;

import java.io.Serializable;

public class CardetailEntity implements Serializable {
	private int detailid;
	private String detailname;
	private int sortid;
	private String detailguige;
	private String detailtime;
	private String detailremark;
	private int detailflag;
	
	private String flag;
	
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	private CarsortEntity sort=new CarsortEntity();

	public int getDetailid() {
		return detailid;
	}

	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}

	public String getDetailname() {
		return detailname;
	}

	public void setDetailname(String detailname) {
		this.detailname = detailname;
	}

	public int getSortid() {
		return sortid;
	}

	public void setSortid(int sortid) {
		this.sortid = sortid;
	}

	public String getDetailguige() {
		return detailguige;
	}

	public void setDetailguige(String detailguige) {
		this.detailguige = detailguige;
	}

	public String getDetailtime() {
		return detailtime;
	}

	public void setDetailtime(String detailtime) {
		this.detailtime = detailtime;
	}

	public String getDetailremark() {
		return detailremark;
	}

	public void setDetailremark(String detailremark) {
		this.detailremark = detailremark;
	}

	public int getDetailflag() {
		return detailflag;
	}

	public void setDetailflag(int detailflag) {
		this.detailflag = detailflag;
	}

	public CarsortEntity getSort() {
		return sort;
	}

	public void setSort(CarsortEntity sort) {
		this.sort = sort;
	}
	
	
	
}
