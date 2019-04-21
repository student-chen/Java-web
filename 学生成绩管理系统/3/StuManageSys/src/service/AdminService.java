package service;

import java.util.List;

import models.Admin;
import models.Course;
import models.Course_teacher;
import models.Student;
import models.Student_course;
import models.Student_courseId;
import models.Teacher;
import dao.IAdminDAO;
import dao.ICourseDAO;
import dao.ICourse_teacherDAO;
import dao.IStudentDAO;
import dao.IStudent_courseDAO;
import dao.ITeacherDAO;

public class AdminService implements IAdminService {
	private IAdminDAO admindao;
//<<<<<<< .mine
    private ITeacherDAO teacherdao;
    private IStudent_courseDAO scdao;
    private ICourse_teacherDAO ctdao;
    private IStudentDAO studao;
	

	public IStudentDAO getStudao() {
		return studao;
	}

	public void setStudao(IStudentDAO studao) {
		this.studao = studao;
	}

	public ICourse_teacherDAO getCtdao() {
		return ctdao;
	}

	public void setCtdao(ICourse_teacherDAO ctdao) {
		this.ctdao = ctdao;
	}

	public IStudent_courseDAO getScdao() {
		return scdao;
	}

	public void setScdao(IStudent_courseDAO scdao) {
		this.scdao = scdao;
	}

	public ITeacherDAO getTeacherdao() {
		return teacherdao;
	}

	public void setTeacherdao(ITeacherDAO teacherdao) {
		this.teacherdao = teacherdao;
	}
//=======
    private IStudentDAO studentdao;
    private ICourseDAO coursedao;
	public ICourseDAO getCoursedao() {
		return coursedao;
	}

	public void setCoursedao(ICourseDAO coursedao) {
		this.coursedao = coursedao;
	}

	public IStudentDAO getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(IStudentDAO studentdao) {
		this.studentdao = studentdao;
	}
//>>>>>>> .r61

	public IAdminDAO getAdmindao() {
		return admindao;
	}

	public void setAdmindao(IAdminDAO admindao) {
		this.admindao = admindao;
	}

	public boolean updateAdminInfo(Admin admin) {
		// TODO Auto-generated method stub
		try{
			admindao.attachDirty(admin);
			return true;
		}
		catch(Exception e){
			return false;
		}	
	}

	public List getallstuInfo(){
		List<Student> allstudent=studentdao.findAll();
		return allstudent;
	}

	public boolean admindeletestu(Student student) {
		// TODO Auto-generated method stub
		try{
			studentdao.delete(student);
			return true;
		}
		catch(Exception e){
			return false;
		}
		
	}
//<<<<<<< .mine
    public List manageTeacher(){
    	return teacherdao.findAll();
    }
    
    public boolean deleteTeacher(Teacher persistentInstance){
    	try{
    		teacherdao.delete(persistentInstance);
    		return true;
    	}catch (Exception e) {
			// TODO: handle exception
    		return false;
		}
    }
    public boolean adminUpdateTeacher(Teacher instance){
    	try{
        	teacherdao.attachDirty(instance);
        	return true;
    	}catch (Exception e) {
             return false;
    	}
    }
    
    public Teacher getOneTeacher(int a){
    	return teacherdao.findById(a);
    }
    public boolean adminAddTeacher(Teacher a){
    	try{
        	teacherdao.save(a);
        	return true;
    	}catch (Exception e) {
             return false;
    	}
    }
    
    
    public List getAllCT(){            //得到教师授课表中的所有记录
    	
    	return ctdao.findAll();
    }
    public boolean deleteCT(Course_teacher a){   //删除指定的教师授课记录
    	try{
    		ctdao.delete(a);
    		return true;
    	}catch (Exception e) {
			// TODO: handle exception
    		return false;
		}
    }
    
    
    public List getAllSC(){             //得到学生选课表中的所有记录
    	return scdao.findAll();
    }
    public boolean deleteSC(int stuId,int CTId){      //删除学生选课表中的选定记录
    	Course_teacher ct=new Course_teacher();
    	ct.setCTId(CTId);
    	
    	Student stu=new Student();
    	stu.setStuId(stuId);
    	
    	
    	Student_courseId scid=new Student_courseId();
    	scid.setCourse_teacher(ct);
    	scid.setStudent(stu);
    	
    	Student_course sc=new Student_course();
    	sc.setId(scid);
    	try{
    		scdao.delete(sc);
    		return true;
    	}catch (Exception e) {
			// TODO: handle exception
    		return false;
		}
    
    }
    public Student getStudent(int id){                //编辑学生信息时所用,根据stuid查找到该学生
    	return studao.findById(id);
    }
    
    public boolean updateGrade(int stuId,int CTId,int grade){  //修改学生成绩
    	Course_teacher ct=new Course_teacher();
    	ct.setCTId(CTId);
    	
    	Student stu=new Student();
    	stu.setStuId(stuId);
    	
    	
    	Student_courseId scid=new Student_courseId();
    	scid.setCourse_teacher(ct);
    	scid.setStudent(stu);
    	
    	Student_course sc=new Student_course();
    	sc.setId(scid);
    	sc.setGrade(grade);
    	try{
    		scdao.attachDirty(sc);
    		return true;
    	}catch (Exception e) {
			// TODO: handle exception
    		return false;
		}
    }
//=======
	
	public Student admingetSelectedStu(int stuid){
		Student student=studentdao.findById(stuid);
		return student;
	}
	
	public boolean adminEditStu(Student student){
		try{
			studentdao.attachDirty(student);
			return true;
		}
		catch(Exception e){
			return false;
		}
		
	}
	
	public boolean adminAddStu(Student student){
		try{
			studentdao.save(student);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public List getallCourseInfo(){
		List<Course> allcourse=coursedao.findAll();
		return allcourse;
	}
	
	public boolean adminDeleteCourse(Course course){
		try{
			coursedao.delete(course);
			return true;
		}
		catch(Exception e){
			return false;
		}	
	}
	
	public Course admingetSelectedCourseInfo(int cid){
		Course selectcourse=coursedao.findById(cid);
		return selectcourse;
	}
	
	public boolean adminEditCourse(Course course){
		try{
			coursedao.attachDirty(course);
			return true;
		}catch(Exception e){
			return false;
		}	
	}
	
	public boolean adminAddCourse(Course course){
		try{
			coursedao.save(course);
			return true;
		}catch(Exception e){
			return false;
		}
	}
//>>>>>>> .r61
}
