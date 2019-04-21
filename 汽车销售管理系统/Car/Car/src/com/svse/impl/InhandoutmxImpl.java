package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.InhandoutmxDAOI;
import com.svse.entity.InhandoutmxEntity;
import com.svse.service.InhandoutmxService;
@Service
public class InhandoutmxImpl implements InhandoutmxService {
	@Autowired
	private InhandoutmxDAOI daoi;
	
	
	@Override
	public void add(InhandoutmxEntity inhandout) {
		
		this.daoi.add(inhandout);
	}

	@Override
	public InhandoutmxEntity getOne(int inhandoutmxid) {
		
		return this.daoi.one(inhandoutmxid);
	}

	@Override
	public List<InhandoutmxEntity> getAll() {
		
		return this.daoi.all();
	}

	@Override
	public List<InhandoutmxEntity> getAll(int offset, int limit,int inhandoutid) {
		
		return this.daoi.all1(offset, limit,inhandoutid);
	}

	@Override
	public int count(int inhandoutid) {
		
		return this.daoi.count(inhandoutid);
	}

	@Override
	public void upp(InhandoutmxEntity inhandoutmx) {
		
		this.daoi.upp(inhandoutmx);
	}

	@Override
	public List<InhandoutmxEntity> getAll(int inhandoutid) {

		return this.daoi.all2(inhandoutid);
	}

	@Override
	public Integer getnow(int inhandoutid) {

		return this.daoi.getnow(inhandoutid);
	}

	@Override
	public Integer getzong(int inhandoutid) {

		return this.daoi.getzong(inhandoutid);
	}

	@Override
	public Integer getfui(int inhandoutid) {

		return this.daoi.getfui(inhandoutid);
	}

	@Override
	public Integer getBuy(int inhandoutid) {

		return this.daoi.getbuy(inhandoutid);
	}

}
