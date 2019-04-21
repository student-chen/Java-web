package com.svse.dao;

import java.util.List;

import com.svse.entity.StorehouseEntity;

public interface StorehouseDAOI {

	// 添加
	public void add(StorehouseEntity storehouse);

	// 修改
	public void upp(StorehouseEntity storehouse);

	// 全查询
	public List<StorehouseEntity> all();
	public List<StorehouseEntity> allstore(int begin,int pages);
	
	// 查询单个
	public StorehouseEntity one(int storeid);
	
	//判断重复
	public int repeat(StorehouseEntity storehouse);
	
	//所有记录
	public int count();
}