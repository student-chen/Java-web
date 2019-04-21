package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.IncarmxDAOI;
import com.svse.entity.InCarEntity;
import com.svse.entity.InCarmxEntity;
import com.svse.service.IncarmxService;

@Service
public class IncarmxImpl implements IncarmxService {
	@Autowired
	private IncarmxDAOI daoi;
	
	
	@Override
	public void add(InCarmxEntity incarmx) {
		
		this.daoi.add(incarmx);
	}

	@Override
	public List<InCarmxEntity> getAll() {
		
		return this.daoi.all();
	}

	@Override
	public List<InCarmxEntity> getAll(int offset, int limit,int incarid) {
		List<InCarmxEntity> ar=this.daoi.all1(offset, limit,incarid);
		for (InCarmxEntity c : ar) {
			if(c.getCarkucunflag()==0){
				c.setFlag("未出售");
			}else{
				c.setFlag("已出售");
			}
		}
		return ar;
	}

	@Override
	public int count(int incarid) {
		
		return this.daoi.count(incarid);
	}

	@Override
	public List<InCarmxEntity> getAll(int incarid) {
		
		return this.daoi.all2(incarid);
	}


	@Override
	public int Rea(InCarmxEntity incarmx) {
		
		return this.daoi.rea(incarmx);
	}

	@Override
	public InCarmxEntity getOne(int incarmcid) {

		return this.daoi.one(incarmcid);
	}

	@Override
	public void upp(InCarmxEntity incarmx) {
		
		this.daoi.upp(incarmx);
	}

	@Override
	public List<InCarmxEntity> getAllLimit(int detailid, int flag,int offset, int limit) {
		List<InCarmxEntity> ar=this.daoi.alllimit(detailid,flag,offset,limit);
		for (InCarmxEntity c : ar) {
			if(c.getCarkucunflag()==0){
				c.setFlag("未出售");
			}else{
				c.setFlag("已出售");
			}
		}
		return ar;
	}
	public int counts(int detailid, int flag) {

		return this.daoi.counts(detailid,flag);
	}
	
	@Override
	public List<InCarmxEntity> getAllLimit1(int flag,int offset, int limit) {
		List<InCarmxEntity> ar=this.daoi.alllimit1(flag,offset,limit);
		for (InCarmxEntity c : ar) {
			if(c.getCarkucunflag()==0){
				c.setFlag("未出售");
			}else{
				c.setFlag("已出售");
			}
		}
		return ar;
	}
	public int counts1(int flag) {

		return this.daoi.counts1(flag);
	}

	@Override
	public List<InCarmxEntity> getAllLimit2(int detailid,int offset, int limit) {
		List<InCarmxEntity> ar=this.daoi.alllimit2(detailid,offset,limit);
		for (InCarmxEntity c : ar) {
			if(c.getCarkucunflag()==0){
				c.setFlag("未出售");
			}else{
				c.setFlag("已出售");
			}
		}
		return ar;
	}
	public int counts2(int detailid) {

		return this.daoi.counts2(detailid);
	}

	@Override
	public List<InCarmxEntity> getAll(int offset, int limit) {
		List<InCarmxEntity> ar=this.daoi.limit(offset,limit);
		for (InCarmxEntity c : ar) {
			if(c.getCarkucunflag()==0){
				c.setFlag("未出售");
			}else{
				c.setFlag("已出售");
			}
		}
		return ar;
	}

	@Override
	public int allcount() {

		return this.daoi.allcount();
	}

	

}
