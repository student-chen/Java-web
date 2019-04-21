package com.svse.dao;

import java.util.List;

import com.svse.entity.InhandoutmxEntity;

public interface InhandoutmxDAOI {

	// 添加
	public void add(InhandoutmxEntity inhandoutmx);

	// 修改
	public void upp(InhandoutmxEntity inhandoutmx);

	// 全查询
	public List<InhandoutmxEntity> all();

	// 查询单个
	public InhandoutmxEntity one(int inhandoutmxid);

	// 分页查询
	public List<InhandoutmxEntity> all1(int offset, int limit, int inhandoutid);

	// 所有记录
	public int count(int inhandoutid);

	public List<InhandoutmxEntity> all2(int inhandoutid);

	// 目前库存量
	public Integer getnow(int inhandoutid);

	// 总库存量
	public Integer getzong(int inhandoutid);

	// 赠送库存量
	public Integer getfui(int inhandoutid);

	public Integer getbuy(int inhandoutid);
}
