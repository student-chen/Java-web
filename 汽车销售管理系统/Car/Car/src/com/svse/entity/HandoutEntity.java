package com.svse.entity;

import java.io.Serializable;

public class HandoutEntity implements Serializable {
	
	private int handoutid;
	private String handoutname;
	private int handoutflag;
	
	private String flag;
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getHandoutid() {
		return handoutid;
	}
	public void setHandoutid(int handoutid) {
		this.handoutid = handoutid;
	}
	public String getHandoutname() {
		return handoutname;
	}
	public void setHandoutname(String handoutname) {
		this.handoutname = handoutname;
	}
	public int getHandoutflag() {
		return handoutflag;
	}
	public void setHandoutflag(int handoutflag) {
		this.handoutflag = handoutflag;
	}
	
	
}
