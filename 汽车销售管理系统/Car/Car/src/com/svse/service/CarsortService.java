package com.svse.service;

import java.util.List;

import com.svse.entity.CarsortEntity;

public interface CarsortService {

	// 添加
	public void addCarsort(CarsortEntity carsort);

	// 修改
	public void uppCarsort(CarsortEntity carsort);

	// 全查询
	public List<CarsortEntity> getAllCarsort();
	public List<CarsortEntity> getAllCarsort(int begin,int pages);
	
	// 查询单个
	public CarsortEntity getOneCarsort(int sortid);

	//判断重复
	public int repeat(CarsortEntity carsort);
	
	//所有记录
	public int Count();
}
