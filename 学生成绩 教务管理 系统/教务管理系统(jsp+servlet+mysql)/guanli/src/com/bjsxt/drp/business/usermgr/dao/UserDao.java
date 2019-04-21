package com.bjsxt.drp.business.usermgr.dao;

import java.sql.Connection;
import java.util.List;

import com.bjsxt.drp.business.usermgr.model.User;

/**
 * 用户增删改查Dao层接口
 */
public interface UserDao {
	
	/**
	 * 增加用户
	 * @param conn
	 * @param user user对象  
	 */
	public void addUser(Connection conn, User user);
	
	/**
	 * 根据userId的集合删除用户
	 * @param conn
	 * @param userIdList  userId的集合
	 */
	public void deleteUsers(Connection conn, String[] userIdList);
	
	/**
	 * 修改用户
	 * @param conn
	 * @param user user对象  
	 */
	public void modifyUser(Connection conn, User user);
	
	/**
	 * 根据用户id查询用户
	 * @param userId 用户id
	 * @return  user对象  
	 */
	public User findUserById(String userId);
	
	/**
	 * 查询所有用户
	 * @return user对象列表
	 */
	public List findAllUserList();
}
