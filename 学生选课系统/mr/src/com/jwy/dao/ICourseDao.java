package com.jwy.dao;

import java.util.List;
import java.util.Map;

import com.jwy.dto.Course;


public interface ICourseDao { 
	public void insert(Course course);		
	public void updateIsFinish(Integer id);	
	public List<Object> findBySearch(Map<String,String> map);
	public Course findByID(Integer id);		
	public List<Course> findByAll();		
	public List<Object[]> findByStat(Map<String,String> map);	
	public List<Object[]> findSelectStu(Integer id);	
}
