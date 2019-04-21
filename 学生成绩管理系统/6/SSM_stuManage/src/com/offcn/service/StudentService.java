package com.offcn.service;

import java.util.List;







import com.offcn.pojo.CourseExt;
import com.offcn.pojo.Grade;
import com.offcn.pojo.Sc;
import com.offcn.pojo.Student;
import com.offcn.pojo.StudentExt;

public interface StudentService {
	List<Student> getStudentPager(int pageNO, int size);
	int getCount();
	int deleteByPrimaryKey(Integer id);//删除
	int multiDelete(int[] ids);
	int insert(Student record);
	Student selectByPrimaryKey(Integer id);
	int updateByPrimaryKey(Student record);
	public List<StudentExt> getStuByCid(int id);
	
	public Student stulogin(Student student);
	
	List<CourseExt> getXuxiu(int classid); 
	
	int inserBatch(List<Sc> sclist);
	 
	List<CourseExt> getMycourses(int classid,int stuid);
	
	/*public Student getMyInfo(int id);
    //public void updatePwd(Login login);
    public int getMyCoursesCount(int id);
    public List<Student> getMyCourses(int id,int pageNum,int size,String type);
    public List<Grade> getGrade(int id);*/
	
}
