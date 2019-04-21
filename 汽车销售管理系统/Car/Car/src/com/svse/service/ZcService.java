package com.svse.service;

import java.util.List;

import com.svse.entity.ZcEntity;

public interface ZcService {

	// 添加
	public void addZc(ZcEntity zc);

	// 修改
	public void uppZc(ZcEntity zc);

	// 全查询
	public List<ZcEntity> getAllZc(int begin,int pages);
	
	// 全查询
	public List<ZcEntity> getAllZc();

	// 查询单个
	public ZcEntity getOneZc(int zid);
	
	//判断重复
	public int repeat(ZcEntity Zc);
	
	//所有记录
	public int Count();
	
}
