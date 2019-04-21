package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.AgroupDAOI;
import com.svse.entity.AGroupEntity;
import com.svse.service.AGroupService;
@Service
public class AGroupImpl implements AGroupService {
	@Autowired
	private AgroupDAOI daoi;
	
	
	@Override
	public List<AGroupEntity> getAll() {
		
		return this.daoi.all();
	}

	@Override
	public List<AGroupEntity> getAll(int begin, int pages) {
		
		return this.daoi.allagroup(begin, pages);
	}

	@Override
	public void uppAGroup(AGroupEntity agroup) {
		
		this.daoi.upp(agroup);
	}

	@Override
	public void addAGroup(AGroupEntity agroup) {
		
		this.daoi.add(agroup);
	}

	@Override
	public void delAGroup(int agroupid) {
		
		this.daoi.del(agroupid);
	}

	@Override
	public int Count() {
		
		return this.daoi.count();
	}


	@Override
	public AGroupEntity getAllByMid(int actionid, int groupid) {
		// TODO Auto-generated method stub
		return this.daoi.allag(actionid, groupid);
	}

}
