package com.svse.dao;

import java.util.List;

import com.svse.entity.ModuleEntity;

public interface ModuleDAOI {

	public List<ModuleEntity> all();
	
	public List<ModuleEntity> allmodule(int begin,int pages);
	
	public int count();
}
