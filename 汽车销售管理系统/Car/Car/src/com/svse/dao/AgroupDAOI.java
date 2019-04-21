package com.svse.dao;

import java.util.List;

import com.svse.entity.AGroupEntity;

public interface AgroupDAOI {

	// 添加
	public void add(AGroupEntity agroup);

	// 修改
	public void upp(AGroupEntity agroup);

	// 删除
	public void del(int agroupid);

	// 全查询
	public List<AGroupEntity> all();

	public List<AGroupEntity> allagroup(int begin, int pages);

	public AGroupEntity allag(int actionid,int groupid);
	
	// 所有记录
	public int count();
}
