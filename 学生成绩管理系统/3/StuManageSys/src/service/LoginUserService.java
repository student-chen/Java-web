package service;

import dao.IAdminDAO;
import dao.IStudentDAO;
import dao.ITeacherDAO;
import dao.TeacherDAO;
import models.Admin;
import models.Student;
import models.Teacher;

public class LoginUserService implements ILoginUserService {
	private ITeacherDAO teacherdao = null;
	private IStudentDAO studentdao=null;
	private IAdminDAO admindao=null;

	public IAdminDAO getAdmindao() {
		return admindao;
	}

	public void setAdmindao(IAdminDAO admindao) {
		this.admindao = admindao;
	}

	public IStudentDAO getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(IStudentDAO studentdao) {
		this.studentdao = studentdao;
	}

	public ITeacherDAO getTeacherdao() {
		return teacherdao;
	}

	public void setTeacherdao(ITeacherDAO teacherdao) {
		this.teacherdao = teacherdao;
	}

	public Student studentLogin(String userid){
		Student student=studentdao.findById(Integer.parseInt(userid));
		if(student==null)
			return null;
		else
			return student;
	}
	public Teacher teacherLogin(String userid) {
		// TODO Auto-generated method stub
		Teacher a = teacherdao.findById(Integer.parseInt(userid));
		if (a == null)
			return null;
		else
			return a;
	}
    
	
	public Admin adminLogin(String userid){
		Admin admin=admindao.findById(Integer.parseInt(userid));
		if(admin==null)
			return null;
		else
			return admin;
	}
}
