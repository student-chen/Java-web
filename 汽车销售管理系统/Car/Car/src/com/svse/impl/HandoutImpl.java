package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.HandoutDAOI;
import com.svse.entity.HandoutEntity;
import com.svse.service.HandoutService;

@Service
public class HandoutImpl implements HandoutService{
	
	@Autowired
	private HandoutDAOI daoi;
	@Override
	public void addHandout(HandoutEntity handout) {
		
		this.daoi.add(handout);
	}

	@Override
	public void uppHandout(HandoutEntity handout) {
		
		this.daoi.upp(handout);
	}

	@Override
	public List<HandoutEntity> getAllHandout() {
		
		return this.daoi.all();
	}

	@Override
	public List<HandoutEntity> getAllHandout(int begin, int pages) {
		List<HandoutEntity> ar=this.daoi.allhandout(begin, pages);
			for (HandoutEntity h : ar) {
				if(h.getHandoutflag()==1){
					h.setFlag("ีýณฃ");
				}else{
					h.setFlag("อฃิห");
				}
			}
		return ar;
	}

	@Override
	public HandoutEntity getOneHandout(int detailid) {
		
		return this.daoi.one(detailid);
	}

	@Override
	public int repeat(HandoutEntity Handout) {
		
		return this.daoi.repeat(Handout);
	}

	@Override
	public int Count() {
		
		return this.daoi.count();
	}

	
}
