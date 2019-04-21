package com.svse.service;

import java.util.List;

import com.svse.entity.HandoutEntity;

public interface HandoutService {

	// 添加
	public void addHandout(HandoutEntity handout);

	// 修改
	public void uppHandout(HandoutEntity handout);

	// 全查询
	public List<HandoutEntity> getAllHandout();
	public List<HandoutEntity> getAllHandout(int begin,int pages);
	
	// 查询单个
	public HandoutEntity getOneHandout(int handoutid);

	//判断重复
	public int repeat(HandoutEntity handout);
	
	//所有记录
	public int Count();
}
