package com.svse.dao;

import java.util.List;

import com.svse.entity.FujianEntity;

public interface FujianDAOI {

	// 添加
	public void add(FujianEntity fujian);

	// 修改
	public void upp(FujianEntity fujian);

	// 全查询
	public List<FujianEntity> allfujian();

	public List<FujianEntity> all(int offset, int limit);

	// 查询单个
	public FujianEntity one(int fjid);

	// 所有记录
	public int count();

	public List<FujianEntity> alls(int incarmxid);

	public List<FujianEntity> all1(int offset, int limit, int inhandoutid);

	public int counts(int inhandoutid);

	public List<FujianEntity> saleall(int offset, int limit);

}
