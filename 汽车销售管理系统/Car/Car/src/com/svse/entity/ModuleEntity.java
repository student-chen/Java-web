package com.svse.entity;

import java.io.Serializable;

public class ModuleEntity implements Serializable {
	
	private int moduleid;
	private String modulename;
	
	public int getModuleid() {
		return moduleid;
	}
	public void setModuleid(int moduleid) {
		this.moduleid = moduleid;
	}
	public String getModulename() {
		return modulename;
	}
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
	
	
}
