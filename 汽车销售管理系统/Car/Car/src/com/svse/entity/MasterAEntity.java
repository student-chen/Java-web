package com.svse.entity;

import java.io.Serializable;

public class MasterAEntity implements Serializable {
	
	private int mgroupid;
	private int mid;
	private int groupid;
	
	private GroupEntity group=new GroupEntity();
	private MasterEntity master=new MasterEntity();
	
	
	
	public GroupEntity getGroup() {
		return group;
	}
	public void setGroup(GroupEntity group) {
		this.group = group;
	}
	public MasterEntity getMaster() {
		return master;
	}
	public void setMaster(MasterEntity master) {
		this.master = master;
	}
	public int getMgroupid() {
		return mgroupid;
	}
	public void setMgroupid(int mgroupid) {
		this.mgroupid = mgroupid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	
}
