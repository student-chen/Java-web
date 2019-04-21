package com.svse.service;

import java.util.List;

import com.svse.entity.PurcarmxEntity;

public interface PurcarmxService {
	
		// 添加
		public void addPurcarmx(PurcarmxEntity purcarmx);

		// 删除
		public void delPurcarmx(int purchaseid);

		// 全查询
		public List<PurcarmxEntity> getAllPurcarmx(int begin,int pages);
		
		public List<PurcarmxEntity> getAllPurcarmx(int purchaseid);
		
		// 查询单个
		public List<PurcarmxEntity> getOnePurcarmx(int Purcarmxid);

		//所有记录
		public int Count();
		
}
