package com.svse.dao;

import java.util.List;

import com.svse.entity.ActionsEntity;

public interface ActionDAOI {

	public List<ActionsEntity> all();
	
	public List<ActionsEntity> allm(int moduleid);
	
	public List<ActionsEntity> allaction(int begin,int pages);
	
	public int count();
}
