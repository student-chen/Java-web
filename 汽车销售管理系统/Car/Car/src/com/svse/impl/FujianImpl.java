package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.FujianDAOI;
import com.svse.entity.FujianEntity;
import com.svse.service.FujianService;
@Service
public class FujianImpl implements FujianService {
	@Autowired
	private FujianDAOI daoi;
	
	@Override
	public void addFuijian(FujianEntity fujian) {
		
		this.daoi.add(fujian);
	}

	@Override
	public void uppFuijian(FujianEntity fujian) {
		
		this.daoi.upp(fujian);
	}

	@Override
	public List<FujianEntity> getAll() {
		
		return this.daoi.allfujian();
	}

	@Override
	public List<FujianEntity> getAll(int offset, int limit) {
		
		return this.daoi.all(offset, limit);
	}

	@Override
	public FujianEntity getOne(int fjid) {
		
		return this.daoi.one(fjid);
	}

	@Override
	public int count() {
		
		return this.daoi.count();
	}

	@Override
	public List<FujianEntity> getAll(int incarmxid) {

		return this.daoi.alls(incarmxid);
	}

	@Override
	public List<FujianEntity> getAll(int offset, int limit, int inhandoutid) {

		return this.daoi.all1(offset, limit,inhandoutid);
	}

	@Override
	public int counts(int inhandoutid) {

		return this.daoi.counts(inhandoutid);
	}

	@Override
	public List<FujianEntity> getAlls(int offset, int limit) {

		return this.daoi.saleall(offset,limit);
	}

}
