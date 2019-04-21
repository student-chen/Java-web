package dao;

import java.util.List;

import entity.Role;

public interface IRole
{
	// 添加
	public void add(Role role);

	// 删除
	public void delete(Role role);

	// 更新
	public void update(Role role);

	// 普通查询
	public List<Role> query(String type, String value);

	// 分页查询
	public List<Role> query(String type, String value, int currentPage);

	// 获取总页数
	public int getCountPage(String type, String value);

}
