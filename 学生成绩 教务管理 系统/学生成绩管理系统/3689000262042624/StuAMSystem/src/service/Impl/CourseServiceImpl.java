package service.Impl;

import java.util.List;

import dao.Impl.CourseDaoImpl;

import model.Course;
import model.PageBean;
import service.CourseService;

public class CourseServiceImpl implements CourseService{
	
	private CourseDaoImpl courseDaoImpl=new CourseDaoImpl();

	public int addCos(Course course, String courseDate) {

		int rs=courseDaoImpl.addCos(course, courseDate);
		return rs;
	}

	public int deleteCos(int courseID) {
		
		int rs = courseDaoImpl.deleteCos(courseID);
		return rs;
	}

	public int editCos(Course course, String courseDate) {
		
		int rs=courseDaoImpl.editCos(course, courseDate);
		return rs;
	}

	public List findAll() {
		
		List rs=courseDaoImpl.findAll();
		return rs;
	}

	public List findOne(int courseID) {
		
		List rs=courseDaoImpl.findOne(courseID);
		return rs;
	}

	public Course selectOneCos(Course cours) {
		
		Course rs=courseDaoImpl.selectOneCos(cours);
		return rs;
	}

	public PageBean courseListPage(int pageNo, int pageCount) {
		
		PageBean rs=courseDaoImpl.courseListPage(pageNo, pageCount);
		return rs;
	}

}
