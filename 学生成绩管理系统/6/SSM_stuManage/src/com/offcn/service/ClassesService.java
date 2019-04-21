package com.offcn.service;

import java.util.List;

import com.offcn.pojo.Classes;

public interface ClassesService {
	List<Classes> getAllClasses();
	
	public List<Classes> getClassPager(int pageNO, int size);

	public Classes getCLassId(int id);

	public int getClassesCount();

	public int insert(Classes entity);

	public int delete(int id);

	int deletes(int[] ids);

	public int update(Classes entity);
	
	public Classes getStuByid(int id);
	
}
