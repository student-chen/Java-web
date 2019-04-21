package com.svse.dao;

import java.util.List;

import com.svse.entity.GroupEntity;

public interface GroupDAOI {

	// 添加
	public void add(GroupEntity group);

	// 修改
	public void upp(GroupEntity group);

	// 全查询
	public List<GroupEntity> all();
	public List<GroupEntity> allgroup(int begin,int pages);
	
	// 查询单个
	public GroupEntity one(int groupid);
	
	//判断重复
	public int repeat(GroupEntity group);
	
	//所有记录
	public int count();
}