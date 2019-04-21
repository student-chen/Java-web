package com.svse.dao;

import java.util.List;

import com.svse.entity.CardetailEntity;
import com.svse.entity.InCarEntity;

public interface IncarDAOI {

	// 添加
	public void add(InCarEntity incar);

	// 修改
	public void upp(InCarEntity incar);

	// 全查询
	public List<InCarEntity> all();

	// 查询单个
	public InCarEntity one(int incarid);

	// 分页查询
	public List<InCarEntity> all1(int offset, int limit);

	// 所有记录
	public int count();

	public List<CardetailEntity> all2();
}
