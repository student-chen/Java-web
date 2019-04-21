package dao;

import java.util.List;

import entity.Score;

public interface IScore
{
	// 添加
	public void add(Score score);

	// 删除
	public void delete(Score score);

	// 更新
	public void update(Score score);

	// 普通查询
	public List<Score> query(String type, String value);

	// 分页查询
	public List<Score> query(String type, String value, int currentPage);

	// 获取总页数
	public int getCountPage(String type, String value);

}
