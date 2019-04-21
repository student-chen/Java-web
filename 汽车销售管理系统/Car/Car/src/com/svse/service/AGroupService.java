package com.svse.service;

import java.util.List;

import com.svse.entity.AGroupEntity;

public interface AGroupService {
	
	//全查询
	public List<AGroupEntity> getAll();
	
	public List<AGroupEntity> getAll(int begin,int pages);
	
	
	//根据actionid和groupid查询
	public AGroupEntity getAllByMid(int actionid,int groupid);
	
	// 修改
	public void uppAGroup(AGroupEntity agroup);
	
	// 添加
	public void addAGroup(AGroupEntity agroup);
	
	// 删除
	public void delAGroup(int agroupid);
	
	public int Count();
}
