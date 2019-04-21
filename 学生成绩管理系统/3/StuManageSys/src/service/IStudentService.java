package service;

import java.util.List;

import models.Student;

public interface IStudentService {

	public abstract void updateStuInfo(Student newstudent);

	public abstract List getAllCourse();
	public boolean selectCourse(int ctid,Student student);
	public List selectcourseResult(Student student);
	public boolean deletecourse(String ctid,Student student);
}