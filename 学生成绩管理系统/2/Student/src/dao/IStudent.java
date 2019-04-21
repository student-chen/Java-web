package dao;

import java.util.List;

import entity.Student;

public interface IStudent
{
	// 添加
	public int add(Student student);

	// 删除
	public void delete(Student student);

	// 更新
	public void update(Student student);

	// 查询
	public List<Student> query(String type, String value);

	// 分页查询
	public List<Student> query(String type, String value, int currentPage);

	// 获取总页数
	public int getCountPage(String type, String value);

}