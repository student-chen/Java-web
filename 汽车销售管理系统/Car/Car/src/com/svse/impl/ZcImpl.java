package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.ZcDAOI;
import com.svse.entity.ZcEntity;
import com.svse.service.ZcService;

@Service
public class ZcImpl implements ZcService{
	@Autowired
	private ZcDAOI daoi;
	
	@Override
	public void addZc(ZcEntity zc) {
		
		this.daoi.addZc(zc);
	}

	@Override
	public void uppZc(ZcEntity zc) {
		
		this.daoi.uppZc(zc);
	}

	@Override
	public List<ZcEntity> getAllZc(int begin,int pages) {
		return this.daoi.allZc(begin, pages);
	}

	@Override
	public ZcEntity getOneZc(int zid) {
		
		return this.daoi.oneZc(zid);
	}

	@Override
	public int repeat(ZcEntity Zc) {
		
		return this.daoi.repeatZc(Zc);
	}

	@Override
	public int Count() {
		return this.daoi.Count();
	}

	@Override
	public List<ZcEntity> getAllZc() {

		return this.daoi.all();
	}
	
	
}
