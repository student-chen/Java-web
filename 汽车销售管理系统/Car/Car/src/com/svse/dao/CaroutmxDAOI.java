package com.svse.dao;

import java.util.List;

import com.svse.entity.CaroutmxEntity;

public interface CaroutmxDAOI {

	// 添加
	public void add(CaroutmxEntity caroutmx);

	// 修改
	public void upp(CaroutmxEntity caroutmx);

	// 全查询
	public List<CaroutmxEntity> allcarout();

	public List<CaroutmxEntity> all(int offset, int limit);

	// 查询单个
	public CaroutmxEntity one(int incarmxid);

	// 所有记录
	public int count();

	public int last();

	public List<CaroutmxEntity> getBySort(int sortid); 

}
