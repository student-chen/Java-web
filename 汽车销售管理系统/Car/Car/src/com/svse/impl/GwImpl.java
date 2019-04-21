package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.GwDAOI;
import com.svse.entity.DeptEntity;
import com.svse.entity.GwEntity;
import com.svse.service.GwService;

@Service
public class GwImpl implements GwService {
	@Autowired
	private GwDAOI daoi;
	
	
	@Override
	public void addGw(GwEntity gw) {
		
		this.daoi.add(gw);
	}

	@Override
	public void uppGw(GwEntity gw) {
		
		this.daoi.upp(gw);
	}

	@Override
	public List<GwEntity> getAllGw() {
		
		return this.daoi.all();
	}

	@Override
	public GwEntity getOneGw(int gid) {
		
		return this.daoi.one(gid);
	}

	@Override
	public List<GwEntity> getGwbyPid(int pid) {
		
		return this.daoi.alldept(pid);
	}

	@Override
	public int repeat(GwEntity gw) {

		return this.daoi.repeat(gw);
	}


}
