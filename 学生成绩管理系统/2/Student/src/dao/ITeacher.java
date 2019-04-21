package dao;

import java.util.List;

import entity.Teacher;

public interface ITeacher
{
	// 添加
	public int add(Teacher teacher);

	// 删除
	public void delete(Teacher teacher);

	// 更新
	public void update(Teacher teacher);

	// 查询
	public List<Teacher> query(String type, String value);

	// 分页查询
	public List<Teacher> query(String type, String value, int currentPage);

	// 获取总页数
	public int getCountPage(String type, String value);

}
