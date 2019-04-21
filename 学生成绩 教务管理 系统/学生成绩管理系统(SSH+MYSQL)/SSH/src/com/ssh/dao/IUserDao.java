package com.ssh.dao;

import java.util.List;

import com.ssh.pojo.UserInfo;

public interface IUserDao {
	public void save(UserInfo userInfo)throws Exception;
	public UserInfo queryByName(String userName)throws Exception;
	
	public List queryAllUser() throws Exception;
}
