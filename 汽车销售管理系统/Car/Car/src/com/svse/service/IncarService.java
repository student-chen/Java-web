package com.svse.service;

import java.util.List;

import com.svse.entity.CardetailEntity;
import com.svse.entity.InCarEntity;

public interface IncarService {

	// 添加
	public void add(InCarEntity incar);
	
	// 添加
	public void upp(InCarEntity incar);

	// 全查询
	public List<InCarEntity> getAll();
	
	public List<InCarEntity> getAll(int offset,int limit);
	
	//查询单个
	public InCarEntity getOne(int incarid);
	
	//所有记录
	public int count();

	//查询汽车
	public List<CardetailEntity> alld();

}
