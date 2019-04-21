package dao;

import java.util.List;

import entity.Operator;

public interface IOperator
{
	// 添加
	public Operator add(Operator operator);

	// 删除
	public void delete(Operator operator);

	// 更新
	public void update(Operator operator);

	// 普通查询
	public List<Operator> query(String type, String value);

	// 分页查询
	public List<Operator> query(String type, String value, int currentPage);

	// 获取总页数
	public int getCountPage(String type, String value);

}
