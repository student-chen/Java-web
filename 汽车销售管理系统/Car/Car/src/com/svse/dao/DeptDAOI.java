package com.svse.dao;

import java.util.List;

import com.svse.entity.DeptEntity;

public interface DeptDAOI {

	// 添加
	public void add(DeptEntity dept);

	// 修改
	public void upp(DeptEntity dept);

	// 全查询
	public List<DeptEntity> all();

	
	// 查询单个
	public DeptEntity one(int pid);
	
	// 查询单个
	public DeptEntity ones(int zjid);
	
	//判断重复
	public int repeat(DeptEntity dept);
	
}