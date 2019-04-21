package com.svse.dao;

import java.util.List;

import com.svse.entity.CardetailEntity;

public interface CardetailDAOI {

	// 添加
	public void add(CardetailEntity cardetail);

	// 修改
	public void upp(CardetailEntity cardetail);

	// 全查询
	public List<CardetailEntity> alldetail(int begin,int pages);
	public List<CardetailEntity> all();
	// 查询单个
	public CardetailEntity one(int detailid);
	
	//所有记录
	public int count();

	public List<CardetailEntity> allbysort(int sortid);
}