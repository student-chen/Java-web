package service;

import java.util.List;

import models.Course;
import models.Course_teacher;
import models.Student;
import models.Student_course;
import models.Student_courseId;
import models.Teacher;
import dao.ICourseDAO;
import dao.ICourse_teacherDAO;
import dao.IStudentDAO;
import dao.IStudent_courseDAO;
import dao.ITeacherDAO;

public class TeacherService {
	private ITeacherDAO teacherdao;
	private ICourse_teacherDAO c_t_dao;
	private ICourseDAO coursedao;
	private IStudent_courseDAO s_c_dao;
	private IStudentDAO studentdao;

	public IStudentDAO getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(IStudentDAO studentdao) {
		this.studentdao = studentdao;
	}

	public IStudent_courseDAO getS_c_dao() {
		return s_c_dao;
	}

	public void setS_c_dao(IStudent_courseDAO s_c_dao) {
		this.s_c_dao = s_c_dao;
	}

	public ICourseDAO getCoursedao() {
		return coursedao;
	}

	public void setCoursedao(ICourseDAO coursedao) {
		this.coursedao = coursedao;
	}

	public ICourse_teacherDAO getC_t_dao() {
		return c_t_dao;
	}

	public void setC_t_dao(ICourse_teacherDAO c_t_dao) {
		this.c_t_dao = c_t_dao;
	}

	public ITeacherDAO getTeacherdao() {
		return teacherdao;
	}

	public void setTeacherdao(ITeacherDAO teacherdao) {
		this.teacherdao = teacherdao;
	}
	public void updateTeachInfo(Teacher instance){
		teacherdao.attachDirty(instance);
	}
	public List<Course_teacher> hasSelect(Teacher t){
		List<Course_teacher> a=c_t_dao.findByProperty("teacher", t);
		return a;
	}
	
	public List<Course> getAll(){
		return coursedao.findAll();
	}
	
	public void sureSelect(Course_teacher instance){
		 c_t_dao.save(instance);
		 
	}
	
	public void cancelSelect(Course_teacher instance){
		
		c_t_dao.delete(instance);
	}
	public List<Course_teacher> showAllSer(){
		return c_t_dao.findAll();
	}
	
	
	public List<Student_course> showOneStu(Integer CTId){
		Course_teacher b=new Course_teacher();
		b.setCTId(CTId);
		
		
		List<Student_course> l=s_c_dao.findByProperty("id.course_teacher", b);
		return l;
	}
	
	public void changeGrade(int ctid,String stuid,int grade){
		int realSid=Integer.parseInt(stuid);
			Course_teacher ct=new Course_teacher();
			ct.setCTId(ctid);
			Student stu=new Student();
			stu.setStuId(realSid);
			
			Student_courseId myid=new Student_courseId();
			myid.setCourse_teacher(ct);
			myid.setStudent(stu);
			
			Student_course sc=new Student_course();
			sc.setId(myid);
			sc.setGrade(grade);
			s_c_dao.attachDirty(sc);
			
		
//		/s_c_dao.attachDirty(instance);
		
	}
	public Student searchStudent(String stuid){
		return studentdao.findById(Integer.parseInt(stuid));
		
	}
	
	

}
