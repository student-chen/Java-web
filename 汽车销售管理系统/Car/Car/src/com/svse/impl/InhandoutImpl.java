package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.InhandoutDAOI;
import com.svse.entity.HandoutEntity;
import com.svse.entity.InhandoutEntity;
import com.svse.service.InhandoutService;
@Service
public class InhandoutImpl implements InhandoutService {
	@Autowired
	private InhandoutDAOI daoi;
	
		
	@Override
	public void add(InhandoutEntity inhandout) {
		
		this.daoi.add(inhandout);
	}

	@Override
	public List<InhandoutEntity> getAll() {
		
		return this.daoi.all();
	}

	@Override
	public List<InhandoutEntity> getAll(int offset, int limit) {
		List<InhandoutEntity> ar=this.daoi.all1(offset, limit);
		for (InhandoutEntity i : ar) {
			if(i.getInhandoutflag()==1){
				i.setFlag("¿â´æ³ä×ã");
			}else{
				i.setFlag("ÔÝÎÞ¿â´æ");
			}
		}
		return ar;
	}

	@Override
	public int count() {
		
		return this.daoi.count();
	}

	@Override
	public void upp(InhandoutEntity inhandout) {
		
		this.daoi.upp(inhandout);
	}

	@Override
	public List<HandoutEntity> allh() {
		
		return this.daoi.allh();
	}

	@Override
	public InhandoutEntity getOne(int inhandoutid) {
		
		return this.daoi.one(inhandoutid);
	}

	@Override
	public int getID() {

		return this.daoi.getid();
	}

	@Override
	public List<InhandoutEntity> getAlls() {

		return this.daoi.alls();
	}

}
