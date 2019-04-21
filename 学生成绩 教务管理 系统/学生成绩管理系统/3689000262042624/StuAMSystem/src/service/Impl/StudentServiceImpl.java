package service.Impl;

import java.util.List;

import dao.Impl.StudentDaoImpl;

import model.PageBean;
import model.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService{
	
	private StudentDaoImpl studentDaoImpl=new StudentDaoImpl();

	public int addStu(Student student) {
		
		int rs=studentDaoImpl.addStu(student);
		return rs;
	}

	public int deleteStu(String stuNum) {
		
		int rs=studentDaoImpl.deleteStu(stuNum);
		return rs;
	}

	public int editStu(Student student) {
	
		int rs=studentDaoImpl.editStu(student);
		return rs;
	}

	public List findAll() {
		
		List rs=studentDaoImpl.findAll();
		return rs;
	}

	public List findOne(String userNum) {
		
		List rs=studentDaoImpl.findOne(userNum);
		return rs;
	}

	public PageBean stuListPage(int pageNo, int pageCount) {
		
		PageBean rs=studentDaoImpl.stuListPage(pageNo, pageCount);
		return rs;
	}

}
