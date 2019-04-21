package com.svse.dao;

import java.util.List;

import com.svse.entity.HandoutEntity;
import com.svse.entity.InhandoutEntity;
public interface InhandoutDAOI {
	// 添加
	public void add(InhandoutEntity inhandout);

	// 修改
	public void upp(InhandoutEntity inhandout);

	// 全查询
	public List<InhandoutEntity> all();

	// 查询单个
	public InhandoutEntity one(int inhandoutid);

	// 分页查询
	public List<InhandoutEntity> all1(int offset, int limit);

	//查询赠品
	public List<HandoutEntity> allh();
	
	// 所有记录
	public int count();

	//得到ID
	public int getid();

	public List<InhandoutEntity> alls();
}
