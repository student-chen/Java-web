package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.ShouDAOI;
import com.svse.entity.ShouEntity;
import com.svse.service.ShouhouService;
@Service
public class ShouImpl implements ShouhouService {
	@Autowired
	private ShouDAOI daoi;
	
	
	@Override
	public void add(ShouEntity shou) {
		
		this.daoi.add(shou);
	}

	@Override
	public void upp(ShouEntity shou) {
		
		this.daoi.upp(shou);
	}	

	@Override
	public List<ShouEntity> getAll() {
		
		return this.daoi.all();
	}

	@Override
	public List<ShouEntity> getAll(int offset, int limit,int mid) {
		
		return this.daoi.all1(offset, limit,mid);
	}

	@Override
	public ShouEntity getOne(int shouhouid) {
		
		return this.daoi.one(shouhouid);
	}

	@Override
	public int count(int mid) {
		
		return this.daoi.count(mid);
	}

	@Override
	public List<ShouEntity> getAlls(int offset, int limit) {
		return this.daoi.all2(offset, limit);
	}

	@Override
	public int counts() {
		return this.daoi.counts();
	}

}
