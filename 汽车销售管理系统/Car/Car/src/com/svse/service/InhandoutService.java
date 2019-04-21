package com.svse.service;

import java.util.List;

import com.svse.entity.HandoutEntity;
import com.svse.entity.InhandoutEntity;

public interface InhandoutService {

	// 添加
	public void add(InhandoutEntity inhandout);

	// 全查询
	public List<InhandoutEntity> getAll();
	
	//查询有库存的赠品表
	public List<InhandoutEntity> getAlls();
	public List<InhandoutEntity> getAll(int offset,int limit);
	
	//修改
	public void upp(InhandoutEntity inhandout);
	
	//查询赠品
	public List<HandoutEntity> allh();
	
	//查询单个
	public InhandoutEntity getOne(int inhandoutid);
	
	//所有记录
	public int count();
	
	//得到inhandoutid
	public int getID();
}
