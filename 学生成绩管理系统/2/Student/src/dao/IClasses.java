package dao;

import java.util.List;
import entity.Classes;

public interface IClasses
{
	// 添加
	public Classes add(Classes classes);

	// 删除
	public void delete(Classes classes);

	// 更新
	public void update(Classes classes);

	// 普通查询
	public List<Classes> query(String type, String value);

	// 分页查询
	public List<Classes> query(String type, String value, int currentPage);

	// 获取总页数
	public int getCountPage(String type, String value);

}
