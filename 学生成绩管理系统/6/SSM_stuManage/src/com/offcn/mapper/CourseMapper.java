package com.offcn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.offcn.pojo.Classes;
import com.offcn.pojo.Course;

public interface CourseMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    
    public List<Course> getCoursePager(@Param("skip") int skip, @Param("size") int size);

	public Course getCourseId(int id);

	public int getCourseCount();

	public int delete(int id);

	public int update(Course entity);
	
	//public List<CourseExt> getMyCourse(int id);
    
    
}