package com.svse.entity;

import java.io.Serializable;

public class GroupEntity implements Serializable {
	private int groupid;
	private String groupname;
	private String groupinfo;
	
	
	private String name;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getGroupinfo() {
		return groupinfo;
	}
	public void setGroupinfo(String groupinfo) {
		this.groupinfo = groupinfo;
	}
	
	
	
	
	
}
