package com.offcn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.offcn.pojo.CourseExt;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Student record);
    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Student record);
    int updateByPrimaryKey(Student record);
    List<Student> getStudentPager(@Param("skip") int skip,@Param("size") int size);
    int getCount();
    
    public List<StudentExt> getStuByCid(int id);
    public Student stulogin(Student student);
    List<CourseExt> getXuxiu(int classid);
    
    List<CourseExt> getBxCourse(int classid);
    List<CourseExt> getxxCourse(int stuid);
    
}