package dao;

import java.util.List;

import entity.Subject;

public interface ISubject
{
	// 添加
	public int add(Subject subject);

	// 删除
	public void delete(Subject subject);

	// 更新
	public void update(Subject subject);

	// 查询
	public List<Subject> query(String type, String value);

	// 分页查询
	public List<Subject> query(String type, String value, int currentPage);

	// 获取总页数
	public int getCountPage(String type, String value);

}
