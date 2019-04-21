package com.svse.entity;

import java.io.Serializable;

public class InhandoutEntity implements Serializable {
	private int inhandoutid;
	private int handoutid;
	private int inhandoutcount;
	private int inhandoutflag;
	private String flag;
	
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	private String handoutname;
	
	private HandoutEntity handout=new HandoutEntity();
	
	
	public HandoutEntity getHandout() {
		return handout;
	}

	public void setHandout(HandoutEntity handout) {
		this.handout = handout;
	}

	public int getInhandoutid() {
		return inhandoutid;
	}

	public void setInhandoutid(int inhandoutid) {
		this.inhandoutid = inhandoutid;
	}

	public int getHandoutid() {
		return handoutid;
	}

	public void setHandoutid(int handoutid) {
		this.handoutid = handoutid;
	}

	public int getInhandoutcount() {
		return inhandoutcount;
	}

	public void setInhandoutcount(int inhandoutcount) {
		this.inhandoutcount = inhandoutcount;
	}

	public int getInhandoutflag() {
		return inhandoutflag;
	}

	public void setInhandoutflag(int inhandoutflag) {
		this.inhandoutflag = inhandoutflag;
	}

	public String getHandoutname() {
		return handoutname;
	}

	public void setHandoutname(String handoutname) {
		this.handoutname = handoutname;
	}
	
	
}
