package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.ActionDAOI;
import com.svse.entity.ActionsEntity;
import com.svse.entity.ModuleEntity;
import com.svse.service.ActionsService;

@Service
public class ActionsImpl implements ActionsService {

	@Autowired
	private ActionDAOI daoi;

	@Override
	public List<ActionsEntity> getAll() {
		
		return this.daoi.all();
	}

	@Override
	public List<ActionsEntity> getAll(int begin, int pages) {
		List<ActionsEntity> ar=this.daoi.allaction(begin, pages);
			for (ActionsEntity a : ar) {
				if(a.getViewmode()==1){
					a.setMode("可见");
				}else{
					a.setMode("不可见");
				}
			}
		return ar;
	}

	@Override
	public int Count() {
		
		return this.daoi.count();
	}

	@Override
	public List<ActionsEntity> getAll(int moduleid) {


		return this.daoi.allm(moduleid);
	}
	
	
}
