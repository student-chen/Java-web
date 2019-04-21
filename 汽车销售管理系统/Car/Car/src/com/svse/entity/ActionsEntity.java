package com.svse.entity;

import java.io.Serializable;

public class ActionsEntity implements Serializable {
	
	private int actionid;
	private int moduleid;
	private String actionname;
	private String action;
	private int viewmode;
	private String mode;
	
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	private ModuleEntity module=new ModuleEntity();
	
	public int getActionid() {
		return actionid;
	}
	public void setActionid(int actionid) {
		this.actionid = actionid;
	}
	public String getActionname() {
		return actionname;
	}
	public void setActionname(String actionname) {
		this.actionname = actionname;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getViewmode() {
		return viewmode;
	}
	public void setViewmode(int viewmode) {
		this.viewmode = viewmode;
	}
	public ModuleEntity getModule() {
		return module;
	}
	public void setModule(ModuleEntity module) {
		this.module = module;
	}
	public int getModuleid() {
		return moduleid;
	}
	public void setModuleid(int moduleid) {
		this.moduleid = moduleid;
	}
	
}
