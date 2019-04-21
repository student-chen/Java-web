package com.svse.service;

import java.util.List;

import com.svse.entity.DeptEntity;

public interface DeptService {

	// 添加
	public void addDept(DeptEntity dept);

	// 修改
	public void uppDept(DeptEntity dept);

	// 全查询
	public List<DeptEntity> getAllDept();

	// 查询单个
	public DeptEntity getOneDept(int pid);
	
	// 查询单个
	public DeptEntity getOneDepts(int zjid);

	//判断重复
	public int repeat(DeptEntity dept);
}
