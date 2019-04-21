package com.svse.service;

import java.util.List;

import com.svse.entity.SaleZengpinEntity;

public interface SaleZengpinService {

	// 添加
	public void addSaleZengpin(SaleZengpinEntity SaleZengpin);

	// 修改
	public void uppSaleZengpin(SaleZengpinEntity SaleZengpin);

	// 全查询
	public List<SaleZengpinEntity> getAll();
	
	public List<SaleZengpinEntity> getAll(int offset, int limit);

	public List<SaleZengpinEntity> getAll(int offset, int limit,int inhandoutid);

	// 查询单个
	public SaleZengpinEntity getOne(int salezpid);

	// 所有记录
	public int count(int inhandoutid);
	public int counts();

	public List<SaleZengpinEntity> getAlls(int offset, int limit);
}
