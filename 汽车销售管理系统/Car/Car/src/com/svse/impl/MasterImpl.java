package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.MasterDAOI;
import com.svse.entity.ActionsEntity;
import com.svse.entity.MasterAEntity;
import com.svse.entity.MasterEntity;
import com.svse.service.MasterService;
@Service
public class MasterImpl implements MasterService {
	@Autowired
	private MasterDAOI daoi;
	
	
	@Override
	public void addMaster(MasterEntity master) {
		
		this.daoi.add(master);
	}

	@Override
	public void uppMaster(MasterEntity master) {
		
		this.daoi.upp(master);
	}

	@Override
	public List<MasterEntity> getAllMaster() {
		
		return this.daoi.all();
	}

	@Override
	public MasterEntity getOneMaster(int mid) {
		
		return this.daoi.one(mid);
	}

	@Override
	public int repeat(MasterEntity master) {
		
		return this.daoi.repeat(master);
	}

	@Override
	public int Count() {

		return 0;
	}

	@Override
	public MasterEntity login(String mname, String mpsw) {
		MasterEntity master=new MasterEntity();
		master.setMname(mname);
		master.setMpsw(mpsw);
		return this.daoi.login(master);
	}

	@Override
	public int find(String mname) {
		
		MasterEntity master=new MasterEntity();
		master.setMname(mname);
		return this.daoi.repeat(master);
	}

	@Override
	public List<ActionsEntity> getLimit(int mid) {
		
		return this.daoi.limit(mid);
	}
	
	@Override
	public List<MasterAEntity> getLimit2(int mid) {
		
		return this.daoi.limit2(mid);
	}

	@Override
	public MasterEntity getOneByPid() {
		
		return this.daoi.getone();
	}



}
