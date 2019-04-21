package com.offcn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Grade;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentView;
import com.offcn.pojo.Teacher;

/**
 * <p>Company: offcn</p>
 * @author zgf
 * @date 2017年5月22日
 * @version 1.0
 */
public interface TeacherService {

	public List<Teacher> getTeacherPager(int pageNO, int size);

	public Teacher getTeacherId(int id);

	public int getTeacherCount();

	public int insert(Teacher entity);

	public int delete(int id);

	public int update(Teacher entity);

	int deletes(int[] ids);
	
	public List<Teacher> getAllTeacher();

	public int getMyStuCount(int id);
	
	public Teacher loginTea(Teacher tea);
	
	public List<StudentView> getMystus(int tid);
	
	int insertGrade(Grade grade);
	
}
