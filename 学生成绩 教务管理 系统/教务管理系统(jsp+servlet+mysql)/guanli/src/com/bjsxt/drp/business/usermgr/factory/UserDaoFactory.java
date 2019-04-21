package com.bjsxt.drp.business.usermgr.factory;

import com.bjsxt.drp.business.usermgr.dao.UserDao;
import com.bjsxt.drp.business.usermgr.dao.UserDao4MySqlImpl;

/**
 * 工厂类，负责动态装载UserDao4MySqlImpl类 
 */
public class UserDaoFactory {
	
	private static UserDaoFactory instance;
	
	private UserDao userDao;
	
	private UserDaoFactory() {
		
		//
		//注意:可以从配置文件中动态装载UserDao4MySqlImpl实现类,便于灵活更换
		//
		userDao = new UserDao4MySqlImpl();
	}
	
	public static synchronized UserDaoFactory getInstance() {
		if (instance == null) {
			instance = new UserDaoFactory();
		}
		return instance;
	}
	
	/**
	 * 创建UserDao对象
	 * @return UserDao UserDao接口
	 */
	public UserDao createUserDao() {
		return userDao;
	}
}
