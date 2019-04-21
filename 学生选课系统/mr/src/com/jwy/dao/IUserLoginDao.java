package com.jwy.dao;

import com.jwy.dto.UserLogin;


public interface IUserLoginDao {
	public UserLogin findbyNameAndPwd(String name,String pwd);		
	public boolean findByLoginName(String loginName);				
	public Integer  findByNPM(String name,String pwd,String mail);	
	public Integer insert(UserLogin user);							
	public void updatePwd(Integer id,String pwd);					
	
}
