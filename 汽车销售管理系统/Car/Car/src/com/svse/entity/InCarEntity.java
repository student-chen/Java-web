package com.svse.entity;

import java.io.Serializable;

public class InCarEntity implements Serializable {
	
	private int incarid;
	private int detailid;
	private int incarcount;
	private int incarflag;
	
	private String detailname;
	private String detailguige;
	private String flag;
	
	
	
	
	public String getDetailguige() {
		return detailguige;
	}
	public void setDetailguige(String detailguige) {
		this.detailguige = detailguige;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getDetailname() {
		return detailname;
	}
	public void setDetailname(String detailname) {
		this.detailname = detailname;
	}
	public int getIncarid() {
		return incarid;
	}
	public void setIncarid(int incarid) {
		this.incarid = incarid;
	}
	public int getDetailid() {
		return detailid;
	}
	public void setDetailid(int detailid) {
		this.detailid = detailid;
	}
	public int getIncarcount() {
		return incarcount;
	}
	public void setIncarcount(int incarcount) {
		this.incarcount = incarcount;
	}
	public int getIncarflag() {
		return incarflag;
	}
	public void setIncarflag(int incarflag) {
		this.incarflag = incarflag;
	}
	
	
	
	
}
