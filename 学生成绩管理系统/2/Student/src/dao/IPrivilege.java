package dao;

import java.util.List;

import entity.Privilege;

public interface IPrivilege
{
	// 添加
	public void add(Privilege privilege);

	// 删除
	public void delete(Privilege privilege);

	// 更新
	public void update(Privilege privilege);

	// 普通查询
	public List<Privilege> query(String type, String value);

	// 分页查询
	public List<Privilege> query(String type, String value, int currentPage);

	// 获取总页数
	public int getCountPage(String type, String value);

}
