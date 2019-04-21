package com.svse.entity;

import java.io.Serializable;
import java.util.List;

public class DeptEntity implements Serializable {

	private int pid;
	private int sjid;
	private int zjid;
	private String zjmc;
	private String zjjs;
	
	//岗位树
	private int gid;
	private String gremark;
	
	//员工树
	private int mid;
	

	
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getGremark() {
		return gremark;
	}

	public void setGremark(String gremark) {
		this.gremark = gremark;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}


	// 这个地方是自己加的-节点名称
	private String name;
	// 这个地方是自己加的--节点图片
	private String icon;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {

		if (pid == 1) {
			this.icon = "";
		}
		this.pid = pid;
	}

	public int getSjid() {
		return sjid;
	}

	public void setSjid(int sjid) {
		this.sjid = sjid;
	}

	public int getZjid() {
		return zjid;
	}

	public void setZjid(int zjid) {
		this.zjid = zjid;
	}

	public String getZjmc() {
		return zjmc;
	}

	public void setZjmc(String zjmc) {
		this.name = zjmc;  //树上的节点名--和数据库的zjmc对上号
		this.zjmc = zjmc;
	}

	public String getZjjs() {
		return zjjs;
	}

	public void setZjjs(String zjjs) {
		this.zjjs = zjjs;
	}

	@Override
    public String toString() {
	return "DeptEntity [pid=" + pid + ", sjid=" + sjid + ", zjid=" + zjid
		+ ", zjmc=" + zjmc + ", zjjs=" + zjjs + "]";
    }
}
