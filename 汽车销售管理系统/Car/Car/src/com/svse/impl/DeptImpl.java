package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.DeptDAOI;
import com.svse.entity.DeptEntity;
import com.svse.service.DeptService;

@Service
public class DeptImpl implements DeptService {
	@Autowired
	private DeptDAOI daoi;
	
	@Override
	public void addDept(DeptEntity dept) {
		
		this.daoi.add(dept);
	}

	@Override
	public void uppDept(DeptEntity dept) {
		
		this.daoi.upp(dept);
	}

	@Override
	public List<DeptEntity> getAllDept() {
		
		return this.daoi.all();
	}

	@Override
	public DeptEntity getOneDept(int pid) {
		
		return this.daoi.one(pid);
	}

	@Override
	public int repeat(DeptEntity dept) {

		return this.daoi.repeat(dept);
	}

	@Override
	public DeptEntity getOneDepts(int zjid) {
		
		return this.daoi.ones(zjid);
	}

}
