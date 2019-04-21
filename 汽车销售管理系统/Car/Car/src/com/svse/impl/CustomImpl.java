package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.CustomDAOI;
import com.svse.entity.CustomEntity;
import com.svse.service.CustomService;
@Service
public class CustomImpl implements CustomService {
	@Autowired
	private CustomDAOI daoi;
		
	@Override
	public void addCustom(CustomEntity custom) {
		
		this.daoi.add(custom);
	}

	@Override
	public List<CustomEntity> getAlls(int mid) {
		
		return this.daoi.all(mid);
	}

	@Override
	public List<CustomEntity> getAll(int offset, int limit) {
		
		return this.daoi.all1(offset,limit);
	}

	@Override
	public int count() {
		
		return this.daoi.count();
	}

	@Override
	public int repeat(CustomEntity custom) {
		
		return this.daoi.repeat(custom);
	}

	@Override
	public List<CustomEntity> getLimit1(int offset, int limit, int pid) {
		
		return this.daoi.limit1(offset,limit,pid);
	}

	@Override
	public List<CustomEntity> getLimit2(int offset, int limit, int mid) {
		
		return this.daoi.limit2(offset,limit,mid);
	}

	@Override
	public int count1(int pid) {
		
		return this.daoi.count1(pid);
	}

	@Override
	public int count2(int mid) {
		
		return this.daoi.count2(mid);
	}

	@Override
	public List<CustomEntity> getAll(int mid) {

		return this.daoi.alllimit(mid);
	}

	@Override
	public List<CustomEntity> getAll() {

		return this.daoi.getall();
	}

}
