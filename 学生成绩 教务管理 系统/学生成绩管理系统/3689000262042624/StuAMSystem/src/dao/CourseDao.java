package dao;

import java.util.List;

import model.Course;
import model.PageBean;


public interface CourseDao {
	/*
	 * 添加课程
	 */
	int addCos(Course course, String courseDate);
	/*
	 * 删除课程
	 */
	int deleteCos(int courseID);
	/*
	 * 修改课程
	 */
	int editCos(Course course,String courseDate);
	/*
	 * 查询所有课程
	 */
	List findAll();
	/*
	 * 查询一个课程
	 */
	List findOne(int courseID);
	/*
	 * 查询该课程是否存在
	 */
	Course selectOneCos(Course cours);
	/*
	 * 分页查询课程
	 */
	PageBean courseListPage(int pageNo,int pageCount);

}
