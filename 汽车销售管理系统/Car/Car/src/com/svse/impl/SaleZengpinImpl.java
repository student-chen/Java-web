package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.SaleZengpinDAOI;
import com.svse.entity.SaleZengpinEntity;
import com.svse.service.SaleZengpinService;
@Service
public class SaleZengpinImpl implements SaleZengpinService {
	@Autowired
	private SaleZengpinDAOI daoi;
	
	
	@Override
	public void addSaleZengpin(SaleZengpinEntity salezp) {
			
		this.daoi.add(salezp);
	}

	@Override
	public void uppSaleZengpin(SaleZengpinEntity salezp) {
		
		this.daoi.upp(salezp);
	}

	@Override
	public List<SaleZengpinEntity> getAll() {
		
		return this.daoi.allsalezp();
	}

	@Override
	public List<SaleZengpinEntity> getAll(int offset, int limit,int inhandoutid) {
		
		return this.daoi.all(offset, limit,inhandoutid);
	}

	@Override
	public SaleZengpinEntity getOne(int salezpid) {
		
		return this.daoi.one(salezpid);
	}

	@Override
	public int count(int inhandoutid) {
		
		return this.daoi.count(inhandoutid);
	}

	@Override
	public List<SaleZengpinEntity> getAll(int offset, int limit) {

		return this.daoi.alls(offset, limit);
	}

	@Override
	public int counts() {

		return this.daoi.counts();
	}

	@Override
	public List<SaleZengpinEntity> getAlls(int offset, int limit) {

		return this.daoi.saleall(offset,limit);
	}

}
