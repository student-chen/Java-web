package com.bjsxt.drp.business.usermgr.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.drp.business.usermgr.dao.UserDao;
import com.bjsxt.drp.business.usermgr.factory.UserDaoFactory;
import com.bjsxt.drp.business.usermgr.model.User;
import com.bjsxt.drp.business.util.DB;

/**
 * 对用户完成增删改查的管理类，采用单例模式实现
 * @author Administrator
 *
 */
public class UserManager {
	
	private static UserManager instance = new UserManager();
	
	private UserDao userDao = null;
	
	private UserManager() {		
		userDao = UserDaoFactory.getInstance().createUserDao();
	}
	
	public static UserManager getInstance() {
		return instance;
	}
	
	/**
	 * 增加用户
	 * @param user user对象
	 */
	public void addUser(User user) {
		Connection conn = null;
		try {
			conn = DB.getConn();
			userDao.addUser(conn, user);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 根据用户代码查询
	 * @param userId 用户代码
	 * @return user对象
	 */
	public User findUserById(String userId) {
		User user = null;
		try {
			user = userDao.findUserById(userId);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 查询所有用户
	 * @return user对象列表
	 */
	public List findAllUserList() {
		List userList = new ArrayList();
		try {
			userList = userDao.findAllUserList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	} 
	
	/**
	 * 根据UserId的集合进行删除
	 * @param userIds userId的集合
	 */
	public void deleteUsers(String[] userIdList) {
		Connection conn = null;
		try {
			conn = DB.getConn();
			userDao.deleteUsers(conn, userIdList);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.closeConn(conn);
		}
	}
	
	/**
	 * 修改用户
	 * @param user user对象
	 */
	public void modifyUser(User user) {
		Connection conn = null;
		try {
			conn = DB.getConn();
			userDao.modifyUser(conn, user);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DB.closeConn(conn);
		}
	}
}
