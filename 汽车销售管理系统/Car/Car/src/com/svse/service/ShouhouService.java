package com.svse.service;

import java.util.List;

import com.svse.entity.ShouEntity;

public interface ShouhouService {

	// 添加
	public void add(ShouEntity shou);

	// 添加
	public void upp(ShouEntity shou);

	// 全查询
	public List<ShouEntity> getAll();
	public List<ShouEntity> getAlls(int offset, int limit);
	public List<ShouEntity> getAll(int offset, int limit,int mid);

	// 查询单个
	public ShouEntity getOne(int shouhouid);

	// 所有记录
	public int count(int mid);
	
	public int counts();

}
