package com.svse.dao;

import java.util.List;

import com.svse.entity.CustomEntity;

public interface CustomDAOI {

	//添加
	public void add(CustomEntity custom);
	
	//全查询
	public List<CustomEntity> all(int mid);

	public List<CustomEntity> all1(int offset, int limit);
	
	//所有记录
	public int count();

	//判断重复
	public int repeat(CustomEntity custom);

	public List<CustomEntity> limit1(int offset, int limit, int pid);

	public int count1(int pid);

	//权限
	public List<CustomEntity> limit2(int offset, int limit, int mid);
	public List<CustomEntity> alllimit(int mid);
	public int count2(int mid);

	public List<CustomEntity> getall();
	
}
