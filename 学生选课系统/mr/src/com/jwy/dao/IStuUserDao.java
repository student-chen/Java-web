package com.jwy.dao;

import java.util.List;

import com.jwy.dto.StuUser;


public interface IStuUserDao {
	public StuUser findById(Integer id);			
	public List<Object[]> findSelect(Integer id);	
	public List<Object[]> findSelected(Integer id);	
	public void insert(StuUser user);				
	public void insertSC(String[] courseIds,Integer stuId);	
}
