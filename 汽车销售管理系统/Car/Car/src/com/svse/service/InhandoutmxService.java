package com.svse.service;

import java.util.List;

import com.svse.entity.InhandoutmxEntity;

public interface InhandoutmxService {

	// 添加
	public void add(InhandoutmxEntity inhandout);

	//查询单个
	public InhandoutmxEntity getOne(int inhandoutmxid);
	
	//修改
	public void upp(InhandoutmxEntity inhandout);
	
	// 全查询
	public List<InhandoutmxEntity> getAll();
	
	public List<InhandoutmxEntity> getAll(int inhandoutid);
	
	public List<InhandoutmxEntity> getAll(int offset,int limit,int inhandoutid);
	
	//所有记录
	public int count(int inhandoutid);
	
	//目前库存量（明细表）
	public Integer getnow(int inhandoutid);
	
	//总库存量（入库表）
	public Integer getzong(int inhandoutid);
	
	//赠送库存量（赠送表）
	public Integer getfui(int inhandoutid);

	public Integer getBuy(int inhandoutid);
}
