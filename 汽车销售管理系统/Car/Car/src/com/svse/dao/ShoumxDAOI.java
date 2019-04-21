package com.svse.dao;

import java.util.List;

import com.svse.entity.ShoumxEntity;

public interface ShoumxDAOI {
	// 添加
	public void add(ShoumxEntity shoumx);

	// 修改
	public void upp(ShoumxEntity shoumx);

	// 全查询
	public List<ShoumxEntity> all();

	// 查询单个
	public ShoumxEntity one(int shouhoumxid);

	// 分页查询
	public List<ShoumxEntity> all1(int offset, int limit,int shouhouid);

	// 所有记录
	public int count(int shouhouid);

}
