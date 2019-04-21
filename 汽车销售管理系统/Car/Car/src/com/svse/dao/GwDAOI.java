package com.svse.dao;

import java.util.List;

import com.svse.entity.DeptEntity;
import com.svse.entity.GwEntity;

public interface GwDAOI {

	// 添加
	public void add(GwEntity gw);

	// 修改
	public void upp(GwEntity gw);

	// 全查询
	public List<GwEntity> all();
	
	// 全查询
	public List<GwEntity> alldept(int pid);

	// 查询单个
	public GwEntity one(int gid);
	
	//判断重复
	public int repeat(GwEntity gw);
	
}