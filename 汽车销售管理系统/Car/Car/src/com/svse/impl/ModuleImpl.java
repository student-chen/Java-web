package com.svse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svse.dao.ModuleDAOI;
import com.svse.entity.ModuleEntity;
import com.svse.service.ModuleService;

@Service
public class ModuleImpl implements ModuleService {

	@Autowired
	private ModuleDAOI daoi;
	
	@Override
	public List<ModuleEntity> getAllModule() {
		
		return this.daoi.all();
	}

	@Override
	public List<ModuleEntity> getAllModule(int begin, int pages) {
		
		return this.daoi.allmodule(begin, pages);
	}

	@Override
	public int Count() {
		
		return this.daoi.count();
	}

}
