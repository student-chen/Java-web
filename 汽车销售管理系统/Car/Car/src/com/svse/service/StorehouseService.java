package com.svse.service;

import java.util.List;

import com.svse.entity.StorehouseEntity;

public interface StorehouseService {

	// 添加
	public void addStorehouse(StorehouseEntity storehouse);

	// 修改
	public void uppStorehouse(StorehouseEntity storehouse);

	// 全查询
	public List<StorehouseEntity> getAllStorehouse();
	public List<StorehouseEntity> getAllStorehouse(int begin,int pages);
	
	// 查询单个
	public StorehouseEntity getOneStorehouse(int storeid);

	//判断重复
	public int repeat(StorehouseEntity storehouse);
	
	//所有记录
	public int Count();
}
