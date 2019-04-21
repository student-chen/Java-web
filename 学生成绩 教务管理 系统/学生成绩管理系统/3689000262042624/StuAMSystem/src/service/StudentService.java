package service;

import java.util.List;

import model.PageBean;
import model.Student;

public interface StudentService {
	/*
	 * 添加学生
	 */
	int addStu(Student student);
	/*
	 * 删除学生
	 */
	int deleteStu(String stuNum);
	/*
	 * 修改学生
	 */
	int editStu(Student student);
	/*
	 * 查询所有学生
	 */
	List findAll();
	/*
	 * 查询一个学生
	 */
	List findOne(String userNum);
	/*
	 * 分页显示学生
	 */
	public PageBean stuListPage(int pageNo, int pageCount);

}
