package com.svse.dao;

import java.util.List;

import com.svse.entity.PurchaseEntity;

public interface PurchaseDAOI {

	// 添加
	public void add(PurchaseEntity purchase);

	// 修改
	public void upp(PurchaseEntity purchase);

	// 全查询
	public List<PurchaseEntity> all();

	public List<PurchaseEntity> allpurchase(int begin, int pages, int mid);
	
	public List<PurchaseEntity> all1(int begin, int pages, int mid);
	
	public List<PurchaseEntity> all2(int begin, int pages,int purchaseflag, int mid);
	
	// 查询单个
	public PurchaseEntity one(int purchaseid);
	
	
	// 所有记录
	public int count(int mid);
	
	public int count1(int mid);
	
	public int count2(int purchaseflag,int mid);
	
	public int count3(int mid);
	
	public int last();

	public int getcount(int mid);

	public List<PurchaseEntity> all3(int begin, int pages, int mid);


}
