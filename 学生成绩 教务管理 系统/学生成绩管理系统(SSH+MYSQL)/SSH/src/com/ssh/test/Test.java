package com.ssh.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ssh.dao.IUserDao;
import com.ssh.pojo.UserInfo;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new FileSystemXmlApplicationContext("D:/Project/MyEclipse_Project/SSH/WebRoot/WEB-INF/spring-config.xml");
		IUserDao userDao = (IUserDao)context.getBean("userDaoProxy");
		UserInfo userInfo = new UserInfo("tom23ee",33);
		try {
			//userDao.save(userInfo);
			userInfo = userDao.queryByName("test01");
			System.out.println(userInfo.getAge());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
