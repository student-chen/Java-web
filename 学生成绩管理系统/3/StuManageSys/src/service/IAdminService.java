package service;

import java.util.List;

import models.Admin;
import models.Course_teacher;
import models.Student;
import models.Teacher;
import models.Course;

public interface IAdminService {
	public boolean updateAdminInfo(Admin admin);

	public List manageTeacher();
	public boolean deleteTeacher(Teacher persistentInstance);
	public boolean adminUpdateTeacher(Teacher instance);
	public Teacher getOneTeacher(int a);
	public boolean adminAddTeacher(Teacher a);
	public List getAllCT();
	public boolean deleteCT(Course_teacher a);
	public List getAllSC();
    public boolean deleteSC(int CTId,int stuId);
    public Student getStudent(int id);
    public boolean updateGrade(int stuId,int CTId,int grade);

    public List getallstuInfo();
	public boolean admindeletestu(Student student);
	public Student admingetSelectedStu(int stuid);
	public boolean adminEditStu(Student student);
	public boolean adminAddStu(Student student);
	public List getallCourseInfo();
	public boolean adminDeleteCourse(Course course);
	public Course admingetSelectedCourseInfo(int cid);
	public boolean adminEditCourse(Course course);
	public boolean adminAddCourse(Course course);
}