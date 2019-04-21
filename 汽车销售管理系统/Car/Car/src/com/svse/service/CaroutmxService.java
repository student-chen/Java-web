package com.svse.service;

import java.util.List;

import com.svse.entity.CaroutmxEntity;

public interface CaroutmxService {

	// 添加
	public void addCarout(CaroutmxEntity carout);

	// 修改
	public void uppCarout(CaroutmxEntity carout);

	// 全查询
	public List<CaroutmxEntity> getAll();

	public List<CaroutmxEntity> getAll(int offset, int limit);
	
	public List<CaroutmxEntity> getBySort(int sortid);
	
	// 查询单个
	public CaroutmxEntity getOne(int catoutmxid);

	//所有记录
	public int count();
	
	//得到Last
	public int last();
	
}
