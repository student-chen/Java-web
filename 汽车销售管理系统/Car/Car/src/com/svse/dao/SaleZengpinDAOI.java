package com.svse.dao;

import java.util.List;

import com.svse.entity.SaleZengpinEntity;

public interface SaleZengpinDAOI {

	// 添加
	public void add(SaleZengpinEntity salezp);

	// 修改
	public void upp(SaleZengpinEntity salezp);

	// 全查询
	public List<SaleZengpinEntity> allsalezp();

	public List<SaleZengpinEntity> all(int offset, int limit, int inhandoutid);

	// 查询单个
	public SaleZengpinEntity one(int salezpid);

	// 所有记录
	public int count(int inhandoutid);

	public List<SaleZengpinEntity> alls(int offset, int limit);

	public int counts();

	public List<SaleZengpinEntity> saleall(int offset, int limit);

}
