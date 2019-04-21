package com.svse.service;

import java.util.List;

import com.svse.entity.CustomEntity;

public interface CustomService {

	// 添加
	public void addCustom(CustomEntity custom);

	// 全查询
	public List<CustomEntity> getAll();
	public List<CustomEntity> getAlls(int mid);
	public List<CustomEntity> getAll(int offset,int limit);
	
	//权限
	public List<CustomEntity> getLimit1(int offset,int limit,int pid);
	public int count1(int pid);
	//权限
	public List<CustomEntity> getLimit2(int offset,int limit,int mid);
	public List<CustomEntity> getAll(int mid);
	public int count2(int mid);
	// 所有记录
	public int count();

	// 判断重复
	public int repeat(CustomEntity custom);

	
}
