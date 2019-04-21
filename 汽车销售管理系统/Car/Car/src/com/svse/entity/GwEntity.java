package com.svse.entity;

import java.io.Serializable;

public class GwEntity implements Serializable{
	
	private int gid;
	private int sjid;
	private int zjid;
	private String gname;
	private String gremark;
	private int pid;
	
	
	private DeptEntity dept=new DeptEntity();

	
	
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

	

	public int getZjid() {
		return zjid;
	}

	public void setZjid(int zjid) {
		this.zjid = zjid;
	}

	public int getSjid() {
		return sjid;
	}

	public void setSjid(int sjid) {
		this.sjid = sjid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGremark() {
		return gremark;
	}

	public void setGremark(String gremark) {
		this.gremark = gremark;
	}

	public DeptEntity getDept() {
		return dept;
	}

	public void setDept(DeptEntity dept) {
		this.dept = dept;
	}
	
	
	
}
