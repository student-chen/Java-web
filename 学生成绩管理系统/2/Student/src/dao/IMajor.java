package dao;

import java.util.List;
import entity.Major;

public interface IMajor
{
	// 添加
	public int add(Major major);

	// 删除
	public void delete(Major major);

	// 更新
	public void update(Major major);

	// 普通查询
	public List<Major> query(String type, String value);

	// 分页查询
	public List<Major> query(String type, String value, int currentPage);

	// 获取总页数
	public int getCountPage(String type, String value);

}
