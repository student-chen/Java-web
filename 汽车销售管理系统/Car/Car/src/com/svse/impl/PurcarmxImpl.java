package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.PurcarmxDAOI;
import com.svse.entity.PurcarmxEntity;
import com.svse.service.PurcarmxService;
@Service
public class PurcarmxImpl implements PurcarmxService {
	
	@Autowired
	private PurcarmxDAOI daoi;
	
	public void addPurcarmx(PurcarmxEntity purcarmx) {
			
		this.daoi.add(purcarmx);
	}

	
	public void delPurcarmx(int purchaseid) {
		
		this.daoi.del(purchaseid);
	}

	
	public List<PurcarmxEntity> getAllPurcarmx(int begin, int pages) {
		
		return this.daoi.allpurcarmx(begin, pages);
	}

	
	public List<PurcarmxEntity> getAllPurcarmx(int purchaseid) {
		
		return this.daoi.all(purchaseid);
	}

	
	public List<PurcarmxEntity> getOnePurcarmx(int purchaseid) {
		
		return this.daoi.one(purchaseid);
	}

	
	public int Count() {
		
		return this.daoi.count();
	}

}
