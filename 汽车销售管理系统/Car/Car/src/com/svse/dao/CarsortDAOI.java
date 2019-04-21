package com.svse.dao;

import java.util.List;

import com.svse.entity.CarsortEntity;

public interface CarsortDAOI {

	// 添加
	public void add(CarsortEntity carsort);

	// 修改
	public void upp(CarsortEntity carsort);

	// 全查询
	public List<CarsortEntity> all();
	public List<CarsortEntity> allsort(int begin,int pages);
	
	// 查询单个
	public CarsortEntity one(int sortid);
	
	//判断重复
	public int repeat(CarsortEntity carsort);
	
	//所有记录
	public int count();
}