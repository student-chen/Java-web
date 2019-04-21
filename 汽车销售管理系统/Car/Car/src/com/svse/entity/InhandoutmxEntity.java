package com.svse.entity;

import java.io.Serializable;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class InhandoutmxEntity implements Serializable {
	private int inhandoutmxid;
	private int inhandoutid;
	private int handoutid;
	private int storeid;
	
	private String handoutcolor;
	private String handoutsize;
	private String handoutimg;
	private int inhandoutnum;
	private String handouttime;
	private String handoutremark;
	
	private String handoutname;
	private String storename;
	private String zjmc;
	private String mname;
	private String mrealname;
	private Integer zong;
	private Integer fui;
	private Integer buy;
	private Integer now;
	
	
	
	
	public String getMrealname() {
		return mrealname;
	}
	public void setMrealname(String mrealname) {
		this.mrealname = mrealname;
	}
	public Integer getZong() {
		return zong;
	}
	public void setZong(Integer zong) {
		this.zong = zong;
	}
	public Integer getFui() {
		return fui;
	}
	public void setFui(Integer fui) {
		this.fui = fui;
	}
	public Integer getBuy() {
		return buy;
	}
	public void setBuy(Integer buy) {
		this.buy = buy;
	}
	public Integer getNow() {
		return now;
	}
	public void setNow(Integer now) {
		this.now = now;
	}
	public String getHandoutname() {
		return handoutname;
	}
	public void setHandoutname(String handoutname) {
		this.handoutname = handoutname;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	
	public String getZjmc() {
		return zjmc;
	}
	public void setZjmc(String zjmc) {
		this.zjmc = zjmc;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	private CommonsMultipartFile img;
	
	
	public CommonsMultipartFile getImg() {
		return img;
	}
	public void setImg(CommonsMultipartFile img) {
		this.img = img;
	}
	private int pid;
	private int mid;
	public int getInhandoutmxid() {
		return inhandoutmxid;
	}
	public void setInhandoutmxid(int inhandoutmxid) {
		this.inhandoutmxid = inhandoutmxid;
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
	public int getStoreid() {
		return storeid;
	}
	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}
	public String getHandoutcolor() {
		return handoutcolor;
	}
	public void setHandoutcolor(String handoutcolor) {
		this.handoutcolor = handoutcolor;
	}
	public String getHandoutsize() {
		return handoutsize;
	}
	public void setHandoutsize(String handoutsize) {
		this.handoutsize = handoutsize;
	}
	public String getHandoutimg() {
		return handoutimg;
	}
	public void setHandoutimg(String handoutimg) {
		this.handoutimg = handoutimg;
	}
	public int getInhandoutnum() {
		return inhandoutnum;
	}
	public void setInhandoutnum(int inhandoutnum) {
		this.inhandoutnum = inhandoutnum;
	}
	public String getHandouttime() {
		return handouttime;
	}
	public void setHandouttime(String handouttime) {
		this.handouttime = handouttime;
	}
	public String getHandoutremark() {
		return handoutremark;
	}
	public void setHandoutremark(String handoutremark) {
		this.handoutremark = handoutremark;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	
	
}
