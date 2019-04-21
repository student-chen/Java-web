package com.jwy.dao;

import java.util.List;

import com.jwy.dto.Specialty;


public interface ISpecialtyDao {
	public void insert(Specialty specialty);	
	public void updateIsFinish(Integer id);		
	public Specialty findById(Integer id);		
	public List<Specialty> findByAll();			
	public List<Specialty> findStuByAll();		
}
