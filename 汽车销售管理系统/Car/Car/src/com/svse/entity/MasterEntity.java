package com.svse.entity;

import java.io.Serializable;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class MasterEntity implements Serializable{
	
	private int mid;
	private String mname;
	private String mpsw;
	private String mrealname;
	private int pid;
	private int gid;
	private int zid;
	private String mtel;
	private String mimg;
	
	private DeptEntity dept=new DeptEntity();
	private ZcEntity zc=new ZcEntity();
	private GwEntity gw=new GwEntity();
	
	private CommonsMultipartFile img;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMpsw() {
		return mpsw;
	}

	public void setMpsw(String mpsw) {
		this.mpsw = mpsw;
	}

	public String getMrealname() {
		return mrealname;
	}

	public void setMrealname(String mrealname) {
		this.mrealname = mrealname;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getZid() {
		return zid;
	}

	public void setZid(int zid) {
		this.zid = zid;
	}

	public String getMtel() {
		return mtel;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public DeptEntity getDept() {
		return dept;
	}

	public void setDept(DeptEntity dept) {
		this.dept = dept;
	}

	public ZcEntity getZc() {
		return zc;
	}

	public void setZc(ZcEntity zc) {
		this.zc = zc;
	}

	public GwEntity getGw() {
		return gw;
	}

	public void setGw(GwEntity gw) {
		this.gw = gw;
	}

	public CommonsMultipartFile getImg() {
		return img;
	}

	public void setImg(CommonsMultipartFile img) {
		this.img = img;
	}
	
	
	
}
