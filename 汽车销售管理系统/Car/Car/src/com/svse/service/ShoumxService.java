package com.svse.service;

import java.util.List;

import com.svse.entity.ShoumxEntity;

public interface ShoumxService {

	// 添加
	public void add(ShoumxEntity shoumx);

	// 添加
	public void upp(ShoumxEntity shoumx);

	// 全查询
	public List<ShoumxEntity> getAll();

	public List<ShoumxEntity> getAll(int offset, int limit,int shouhouid);

	// 查询单个
	public ShoumxEntity getOne(int shouhoumxid);

	// 所有记录
	public int count(int shouhouid);

}
