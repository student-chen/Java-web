package com.svse.service;

import java.util.List;

import com.svse.entity.MasterAEntity;

public interface MasterAService {
	
	//全查询
	public List<MasterAEntity> getAll();
	
	public List<MasterAEntity> getAll(int begin,int pages);
	
	
	//根据mid和groupid查询
	public MasterAEntity getAllByMid(int mid,int groupid);
	
	// 修改
	public void uppMasterA(MasterAEntity MasterA);
	
	// 添加
	public void addMasterA(MasterAEntity MasterA);
	
	// 删除
	public void delMasterA(int MasterAid);
	
	public int Count();
}
