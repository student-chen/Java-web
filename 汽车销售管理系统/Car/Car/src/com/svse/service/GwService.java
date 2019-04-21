package com.svse.service;

import java.util.List;

import com.svse.entity.DeptEntity;
import com.svse.entity.GwEntity;

public interface GwService {

	// 添加
	public void addGw(GwEntity gw);

	// 修改
	public void uppGw(GwEntity gw);

	// 全查询
	public List<GwEntity> getAllGw();

	// 查询单个
	public GwEntity getOneGw(int gid);

	// 查询该部门下岗位
	public List<GwEntity> getGwbyPid(int pid);

	public int repeat(GwEntity gw);
	
	
}
