package com.tsinghuait.st0717.hospitalsystem.dao;

import java.sql.ResultSet;

public class ReceiptDAO extends SQLServerDBManager {
	/**
	 * 保存作者信息
	 * 
	 * */
	public void savePost(String sql)
	{
		saveData(sql);
	}
	/**
	 * 加载所有的作者信息
	 * 
	 * */
	public ResultSet loadAllPosts()
	{
		return execQuery("select * from post");
	}
	
	/**
	 * 按作者的id进行删除
	 * 
	 * @return 影响的行数
	 * */
	public int deletePostById(String sql)
	{
		return deleteData(sql);
	}
}
