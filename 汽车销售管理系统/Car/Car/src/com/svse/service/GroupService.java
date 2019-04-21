package com.svse.service;

import java.util.List;

import com.svse.entity.GroupEntity;
import com.svse.entity.ModuleEntity;

public interface GroupService {
	
	//È«²éÑ¯
	public List<GroupEntity> getAllGroup();
	
	public List<GroupEntity> getAllGroup(int begin,int pages);
	
	public void addGroup(GroupEntity group);
	
	public void uppGroup(GroupEntity group);
	
	public GroupEntity getOneGroup(int groupid);
	
	public int Count();

	public int repeat(GroupEntity group);
}
