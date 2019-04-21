package service;

import java.util.List;

import model.PageBean;
import model.Teacher;

public interface TeacherService {
	/*
	 * 添加教师
	 */
	int addTea(Teacher teacher);
	/*
	 * 删除教师
	 */
	int deleteTea(String teaNum);
	/*
	 * 修改教师
	 */
	int editTea(Teacher Teacher);
	/*
	 * 查询所有教师
	 */
	List findAll();
	/*
	 * 查询一个教师
	 */
	List findOne(String teaNum);
	/*
	 * 分页显示所有教师
	 */
	PageBean teaListPage(int pageNo,int pageCount);
}
