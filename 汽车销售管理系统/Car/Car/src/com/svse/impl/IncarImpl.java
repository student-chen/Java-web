package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.IncarDAOI;
import com.svse.entity.CardetailEntity;
import com.svse.entity.InCarEntity;
import com.svse.service.IncarService;

@Service
public class IncarImpl implements IncarService {
	@Autowired 
	private IncarDAOI daoi;
	
	
	
	@Override
	public void add(InCarEntity incar) {
		
		this.daoi.add(incar);
	}

	@Override
	public List<InCarEntity> getAll() {
		
		return this.daoi.all();
	}

	@Override
	public List<InCarEntity> getAll(int offset, int limit) {
		List<InCarEntity> ar=this.daoi.all1(offset, limit);
		for (InCarEntity c : ar) {
			if(c.getIncarflag()==0){
				c.setFlag("ÔÝÎÞ¿â´æ");
			}else{
				c.setFlag("¿â´æ³ä×ã");
			}
		}
		return ar;
	}

	@Override
	public int count() {
		
		return this.daoi.count();
	}

	@Override
	public void upp(InCarEntity incar) {
		this.daoi.upp(incar);
	}

	@Override
	public InCarEntity getOne(int incarid) {
		// TODO Auto-generated method stub
		return this.daoi.one(incarid);
	}

	@Override
	public List<CardetailEntity> alld() {
		// TODO Auto-generated method stub
		return this.daoi.all2();
	}

}
