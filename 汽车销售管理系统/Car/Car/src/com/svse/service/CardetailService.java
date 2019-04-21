package com.svse.service;

import java.util.List;

import com.svse.entity.CardetailEntity;

public interface CardetailService {

	// 添加
	public void addCardetail(CardetailEntity cardetail);

	// 修改
	public void uppCardetail(CardetailEntity cardetail);

	// 全查询
	public List<CardetailEntity> getAllCardetail(int begin,int pages);
	
	public List<CardetailEntity> getAllCardetail();
	
	//根据品牌查系列
	public List<CardetailEntity> getAllBySort(int sortid);
	
	// 查询单个
	public CardetailEntity getOneCardetail(int detailid);

	//所有记录
	public int Count();
}

