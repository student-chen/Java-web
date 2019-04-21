package com.svse.dao;

import java.util.List;

import com.svse.entity.InCarmxEntity;

public interface IncarmxDAOI {

	// 添加
	public void add(InCarmxEntity incarmx);

	// 全查询
	public List<InCarmxEntity> all();

	// 分页查询
	public List<InCarmxEntity> all1(int offset, int limit, int incarid);

	// 所有记录
	public int count(int incarid);

	// 判断重复
	public int rea(InCarmxEntity incarmx);

	// 得到库存
	public List<InCarmxEntity> all2(int incarid);

	public InCarmxEntity one(int incarmxid);

	// 修改
	public void upp(InCarmxEntity incarmx);

	// 条件查询（系列）
	public List<InCarmxEntity> alllimit2(int detailid,int limit, int offset);
	public int counts2(int detailid);
	
	// 条件查询（状态）
	public List<InCarmxEntity> alllimit1(int flag,int limit, int offset);
	public int counts1(int flag);
	
	// 条件查询（系列、状态）
	public List<InCarmxEntity> alllimit(int detailid, int flag,int limit, int offset);
	public int counts(int detailid, int flag);
	
	//分页查询
	public List<InCarmxEntity> limit(int offset, int limit);

	public int allcount();

}
