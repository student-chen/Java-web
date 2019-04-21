package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.ShoumxDAOI;
import com.svse.entity.ShoumxEntity;
import com.svse.service.ShoumxService;
@Service
public class ShoumxImpl implements ShoumxService{
	@Autowired
	private ShoumxDAOI daoi;
	
	@Override
	public void add(ShoumxEntity shoumx) {
		
		this.daoi.add(shoumx);
	}

	@Override
	public void upp(ShoumxEntity shoumx) {
		
		this.daoi.upp(shoumx);
	}

	@Override
	public List<ShoumxEntity> getAll() {
		
		return this.daoi.all();
	}

	@Override
	public List<ShoumxEntity> getAll(int offset, int limit,int shouhouid) {
		List<ShoumxEntity> ar=this.daoi.all1(offset, limit, shouhouid);
		for (ShoumxEntity ss : ar) {
			if(ss.getShouhouflag()==0){
				ss.setFlag(" ’∑—");
			}else{
				ss.setFlag("√‚∑—");
			}
		}
		return ar;
	}

	@Override
	public ShoumxEntity getOne(int shouhoumxid) {
		
		return this.daoi.one(shouhoumxid);
	}

	@Override
	public int count(int shouhouid) {
		
		return this.daoi.count(shouhouid);
	}


}
