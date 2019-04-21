package com.svse.entity;

import java.io.Serializable;

public class AGroupEntity implements Serializable {
	
	private int actiongroupid;
	private int actionid;
	private int groupid;
	

	private GroupEntity group=new GroupEntity();

	public int getActiongroupid() {
		return actiongroupid;
	}

	public void setActiongroupid(int actiongroupid) {
		this.actiongroupid = actiongroupid;
	}

	public int getActionid() {
		return actionid;
	}

	public void setActionid(int actionid) {
		this.actionid = actionid;
	}

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public GroupEntity getGroup() {
		return group;
	}

	public void setGroup(GroupEntity group) {
		this.group = group;
	}
	
	
	
}
