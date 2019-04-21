package service.Impl;

import java.util.List;

import dao.Impl.TeacherDaoImpl;

import model.PageBean;
import model.Teacher;
import service.TeacherService;

public class TeacherServiceImpl implements TeacherService{
	
	private TeacherDaoImpl teacherDaoImpl=new TeacherDaoImpl();

	public int addTea(Teacher teacher) {
	
		int rs=teacherDaoImpl.addTea(teacher);
		return rs;
	}

	public int deleteTea(String teaNum) {
		
		int rs=teacherDaoImpl.deleteTea(teaNum);
		return rs;
	}

	public int editTea(Teacher teacher) {
		
		int rs=teacherDaoImpl.editTea(teacher);
		return rs;
	}

	public List findAll() {
		
		List rs=teacherDaoImpl.findAll();
		return rs;
	}

	public List findOne(String teaNum) {
		
		List rs=teacherDaoImpl.findOne(teaNum);
		return rs;
	}

	public PageBean teaListPage(int pageNo, int pageCount) {
		
		PageBean rs=teacherDaoImpl.teaListPage(pageNo, pageCount);
		return rs;
	}

}
