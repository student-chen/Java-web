package com.svse.dao;

import java.util.List;

import com.svse.entity.ZcEntity;

public interface ZcDAOI {

	// 添加
	public void addZc(ZcEntity Zc);

	// 修改
	public void uppZc(ZcEntity Zc);

	// 全查询
	public List<ZcEntity> allZc(int begin,int pages);
	public List<ZcEntity> all();
	
	// 查询单个
	public ZcEntity oneZc(int zid);
	
	//判断重复
	public int repeatZc(ZcEntity Zc);
	
	//所有记录
	public int Count();

	
}