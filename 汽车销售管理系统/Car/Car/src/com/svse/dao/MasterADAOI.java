package com.svse.dao;

import java.util.List;

import com.svse.entity.MasterAEntity;

public interface MasterADAOI {

	// 添加
	public void add(MasterAEntity MasterA);

	// 修改
	public void upp(MasterAEntity MasterA);

	// 删除
	public void del(int actiongroupid);

	// 全查询
	public List<MasterAEntity> all();

	public List<MasterAEntity> allMasterA(int begin, int pages);

	public MasterAEntity allmg(int mid,int groupid);
	
	// 所有记录
	public int count();
}
