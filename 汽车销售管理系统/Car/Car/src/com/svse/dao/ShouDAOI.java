package com.svse.dao;

import java.util.List;

import com.svse.entity.ShouEntity;

public interface ShouDAOI {
	// 添加
	public void add(ShouEntity shou);

	// 修改
	public void upp(ShouEntity shou);

	// 全查询
	public List<ShouEntity> all();

	// 查询单个
	public ShouEntity one(int shouhouid);

	// 分页查询
	public List<ShouEntity> all1(int offset, int limit, int mid);

	// 所有记录
	public int count(int mid);

	public List<ShouEntity> all2(int offset, int limit);

	public int counts();

}
