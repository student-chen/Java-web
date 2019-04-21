package com.offcn.mapper;

import com.offcn.pojo.StudentView;
import com.offcn.pojo.Teacher;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);


    Teacher selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    
    public List<Teacher> getTeacherPager(@Param("skip") int skip, @Param("size") int size);

	public Teacher getTeacherId(int id);

	public int getTeacherCount();

	public int delete(int id);

	public int update(Teacher entity);
	
	public List<Teacher> getAllTeacher();
	
	public Teacher loginTea(Teacher tea);
	
	public Teacher tealogin(Teacher teacher);
	
	List<StudentView> getxxStudent(int tid);
	
	List<StudentView> getbxStudent(int tid);
	
    
}