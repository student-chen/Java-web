package com.svse.entity;

import java.io.Serializable;

public class ZcEntity implements Serializable {
	
	private int zid;
	private String zname;
	private String zremark;
	
	private int begin;
	private int count;
	private int allpages;
	private int next;
	private int up;
	private int page;
	
 	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getAllpages() {
		return allpages;
	}
	public void setAllpages(int allpages) {
		this.allpages = allpages;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	public int getZid() {
		return zid;
	}
	public void setZid(int zid) {
		this.zid = zid;
	}
	public String getZname() {
		return zname;
	}
	public void setZname(String zname) {
		this.zname = zname;
	}
	public String getZremark() {
		return zremark;
	}
	public void setZremark(String zremark) {
		this.zremark = zremark;
	}
	
	
	
	
}
