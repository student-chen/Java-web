package com.svse.dao;

import java.util.List;

import com.svse.entity.HandoutEntity;

public interface HandoutDAOI {

	// 添加
	public void add(HandoutEntity handout);

	// 修改
	public void upp(HandoutEntity handout);

	// 全查询
	public List<HandoutEntity> all();
	public List<HandoutEntity> allhandout(int begin,int pages);
	
	// 查询单个
	public HandoutEntity one(int handoutid);
	
	//判断重复
	public int repeat(HandoutEntity handout);
	
	//所有记录
	public int count();
}