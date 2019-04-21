package service;

import java.util.List;

import models.Course_teacher;
import models.Student;
import models.Student_course;
import models.Student_courseId;
import dao.ICourseDAO;
import dao.ICourse_teacherDAO;
import dao.IStudentDAO;
import dao.IStudent_courseDAO;
import dao.ITeacherDAO;

public class StudentService implements IStudentService {
	private IStudentDAO studentdao = null;
    private ICourse_teacherDAO courseteacherdao=null;
    private IStudent_courseDAO studentcoursedao=null;
    //private ICourseDAO coursedao=null;
    //private ITeacherDAO teacherdao=null;

	public IStudent_courseDAO getStudentcoursedao() {
		return studentcoursedao;
	}



	public void setStudentcoursedao(IStudent_courseDAO studentcoursedao) {
		this.studentcoursedao = studentcoursedao;
	}



	public ICourse_teacherDAO getCourseteacherdao() {
		return courseteacherdao;
	}



	public void setCourseteacherdao(ICourse_teacherDAO courseteacherdao) {
		this.courseteacherdao = courseteacherdao;
	}



//	public ICourseDAO getCoursedao() {
//		return coursedao;
//	}
//
//
//
//	public void setCoursedao(ICourseDAO coursedao) {
//		this.coursedao = coursedao;
//	}
//
//
//
//	public ITeacherDAO getTeacherdao() {
//		return teacherdao;
//	}
//
//
//
//	public void setTeacherdao(ITeacherDAO teacherdao) {
//		this.teacherdao = teacherdao;
//	}



	public IStudentDAO getStudentdao() {
		return studentdao;
	}



	public void setStudentdao(IStudentDAO studentdao) {
		this.studentdao = studentdao;
	}



	/* (non-Javadoc)
	 * @see service.IStudentService#updateStuInfo(models.Student)
	 */
	public void updateStuInfo(Student newstudent){
		studentdao.attachDirty(newstudent);
	}
	
	/* (non-Javadoc)
	 * @see service.IStudentService#getAllCourse()
	 */
	public List getAllCourse(){
	  List<Course_teacher> course_teachers=courseteacherdao.findAll();
	  return course_teachers;
	}
	
	public boolean selectCourse(int ctid,Student student){
		Course_teacher ct=courseteacherdao.findById(ctid);
		
		Student_courseId studentcourseid=new Student_courseId();
		studentcourseid.setCourse_teacher(ct);
		studentcourseid.setStudent(student);
		Student_course studentcouse=new Student_course(studentcourseid, -1);
		try{
			studentcoursedao.save(studentcouse);
			return true;
		}
		catch(Exception e){
			return false;
		}
 		
	}
	
	public List selectcourseResult(Student student){
//		Student_courseId studentcourseId=new Student_courseId();
//		studentcourseId.setStudent(student);
//		Course_teacher courseteacher=new Course_teacher();
//		courseteacher.setCTId(10);
//		studentcourseId.setCourse_teacher(courseteacher);
		List<Student_course> studentcourses=studentcoursedao.findByProperty("id.student", student);
		return studentcourses;
	}
	
	public boolean deletecourse(String ctid,Student student){
		Course_teacher courseteacher=new Course_teacher();
		courseteacher.setCTId(Integer.parseInt(ctid));
		Student_course studentcourse=new Student_course();
		Student_courseId studentcourseId=new Student_courseId();
		studentcourseId.setCourse_teacher(courseteacher);
		studentcourseId.setStudent(student);
		studentcourse.setId(studentcourseId);
		try{
			studentcoursedao.delete(studentcourse);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
}
