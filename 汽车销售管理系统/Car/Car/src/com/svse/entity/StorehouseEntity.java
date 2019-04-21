package com.svse.entity;

import java.io.Serializable;

public class StorehouseEntity implements Serializable {
	
	private int storeid;
	private String storename;
	private int storeflag;
	private String flag;
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getStoreid() {
		return storeid;
	}
	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public int getStoreflag() {
		return storeflag;
	}
	public void setStoreflag(int storeflag) {
		this.storeflag = storeflag;
	}
	
	
	
}
