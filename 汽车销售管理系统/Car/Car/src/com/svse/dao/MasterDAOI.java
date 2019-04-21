package com.svse.dao;

import java.util.List;

import com.svse.entity.ActionsEntity;
import com.svse.entity.MasterAEntity;
import com.svse.entity.MasterEntity;

public interface MasterDAOI {

	// 添加
	public void add(MasterEntity master);

	// 修改
	public void upp(MasterEntity master);

	// 全查询
	public List<MasterEntity> all();
	
	// 查询单个
	public MasterEntity one(int mid);
	
	//判断重复
	public int repeat(MasterEntity master);
	
	//登录
	public MasterEntity login(MasterEntity master);

	//权限
	public List<ActionsEntity> limit(int mid);
	
	public List<MasterAEntity> limit2(int mid);

	//得到总经理
	public MasterEntity getone();
	
}