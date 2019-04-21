package com.svse.service;

import java.util.List;

import com.svse.entity.InCarmxEntity;

public interface IncarmxService {

	// 添加
	public void add(InCarmxEntity incarmx);

	// 全查询
	public List<InCarmxEntity> getAll();

	// 所有记录
	public int count(int incarid);

	public List<InCarmxEntity> getAll(int incarid);

	public List<InCarmxEntity> getAll(int offset, int limit, int incarmxid);
	
	//全查询
	public List<InCarmxEntity> getAll(int offset, int limit);
	public int allcount();
	
	// 条件查询（状态、系列）
	public List<InCarmxEntity> getAllLimit(int limit, int offset,int detailid, int flag);
	public int counts(int detailid, int flag);

	// 状态
	public List<InCarmxEntity> getAllLimit1(int limit, int offset,int flag);
	public int counts1(int flag);

	// 系列
	public List<InCarmxEntity> getAllLimit2(int limit, int offset,int detailid);
	public int counts2(int detailid);

	// 判断重复
	public int Rea(InCarmxEntity incarmx);

	public InCarmxEntity getOne(int incarmcid);

	// 修改
	public void upp(InCarmxEntity incarmx);

}
