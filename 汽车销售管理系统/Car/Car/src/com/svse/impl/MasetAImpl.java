package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.MasterADAOI;
import com.svse.entity.MasterAEntity;
import com.svse.service.MasterAService;
@Service
public class MasetAImpl implements MasterAService{
	@Autowired
	private MasterADAOI daoi;
	
	
	
	public List<MasterAEntity> getAll() {
	
		return this.daoi.all();
	}

	
	public List<MasterAEntity> getAll(int begin, int pages) {
	
		return this.daoi.allMasterA(begin, pages);
	}

	
	public MasterAEntity getAllByMid(int mid, int groupid) {
	
		return this.daoi.allmg(mid, groupid);
	}

	
	public void uppMasterA(MasterAEntity MasterA) {
	
		this.daoi.upp(MasterA);
	}

	
	public void addMasterA(MasterAEntity MasterA) {
	
		this.daoi.add(MasterA);
	}

	
	public void delMasterA(int MasterAid) {
	
		this.daoi.del(MasterAid);
	}

	
	public int Count() {
	
		return this.daoi.count();
	}

	
}
