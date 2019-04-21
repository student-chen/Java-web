package com.svse.service;

import java.util.List;

import com.svse.entity.FujianEntity;

public interface FujianService {

	// 添加
	public void addFuijian(FujianEntity fujian);

	// 修改
	public void uppFuijian(FujianEntity fujian);

	// 全查询
	public List<FujianEntity> getAll();

	public List<FujianEntity> getAll(int offset, int limit,int inhandoutid);

	public List<FujianEntity> getAll(int offset, int limit);
	
	// 查询单个
	public FujianEntity getOne(int fjid);

	// 所有记录
	public int count();
	
	public int counts(int inhandoutid);

	public List<FujianEntity> getAll(int incarmxid);

	public List<FujianEntity> getAlls(int offset, int limit);
	
}
