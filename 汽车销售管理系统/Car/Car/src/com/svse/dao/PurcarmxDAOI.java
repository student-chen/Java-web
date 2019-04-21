package com.svse.dao;

import java.util.List;

import com.svse.entity.PurcarmxEntity;

public interface PurcarmxDAOI {

	// 添加
	public void add(PurcarmxEntity purcarmx);

	// 删除
	public void del(int purchaseid);

	// 全查询
	public List<PurcarmxEntity> all(int purchaseid);

	public List<PurcarmxEntity> allpurcarmx(int begin, int pages);

	// 根据采购查询
	public List<PurcarmxEntity> one(int purchaseid);

	// 所有记录
	public int count();

}
