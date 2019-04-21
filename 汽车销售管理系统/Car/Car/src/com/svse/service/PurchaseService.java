package com.svse.service;

import java.util.List;

import com.svse.entity.PurchaseEntity;

public interface PurchaseService {
	
		// 添加
		public void addPurchase(PurchaseEntity purchase);

		// 修改
		public void uppPurchase(PurchaseEntity purchase);

		// 全查询
		public List<PurchaseEntity> getAllPurchase(int begin,int pages, int mid);
		
		public List<PurchaseEntity> getAllPurchase();
		
		// 查询单个
		public PurchaseEntity getOnePurchase(int purchaseid);

		//所有记录
		public int Count(int mid);
		
		public int Count1(int mid);
		
		public int Count2(int purchaseflag,int mid);
		
		public int Count3(int mid);
		
		//条件查询
		public List<PurchaseEntity> getAll(int offset, int limit, int purchaseflag, int mid);
		
		public List<PurchaseEntity> getAll(int offset, int limit, int mid);

		public int getOnePurchase();


		public int getCount(int mid);

		public List<PurchaseEntity> getAlls(int offset, int limit, int mid);
}
