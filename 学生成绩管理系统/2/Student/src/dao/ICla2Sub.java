package dao;

import java.util.List;

import entity.Cla2Sub;

public interface ICla2Sub
{
	// 添加
	public int add(Cla2Sub cla2Sub);

	// 删除
	public void delete(Cla2Sub cla2Sub);

	// 更新
	public void update(Cla2Sub cla2Sub);

	// 普通查询
	public List<Cla2Sub> query(String type, String value);

	// 分页查询
	public List<Cla2Sub> query(String type, String value, int currentPage);

	// 获取总页数
	public int getCountPage(String type, String value);

}
