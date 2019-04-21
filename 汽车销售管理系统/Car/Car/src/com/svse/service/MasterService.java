package com.svse.service;

import java.util.List;

import com.svse.entity.ActionsEntity;
import com.svse.entity.MasterAEntity;
import com.svse.entity.MasterEntity;

public interface MasterService {
	
	//登录
	public MasterEntity login(String mname,String mpsw);
	
	//判断用户名是否存在
	public int find(String mname);
	
	//获得权限
	public List<ActionsEntity> getLimit(int mid);
	
	public List<MasterAEntity> getLimit2(int mid);
	
	// 添加
	public void addMaster(MasterEntity master);

	// 修改
	public void uppMaster(MasterEntity master);

	// 全查询
	public List<MasterEntity> getAllMaster();

	// 查询单个
	public MasterEntity getOneMaster(int mid);

	//判断重复
	public int repeat(MasterEntity master);
	
	//所有记录
	public int Count();
	
	//查询总经办
	public MasterEntity getOneByPid();
	
	
}
