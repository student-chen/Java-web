package com.bjpowernode.system.vo;

import java.util.List;

import com.bjpowernode.system.entity.base.ResourceEntity;
import com.bjpowernode.system.entity.base.UserEntity;

/**
 * 在线用户对象
 * 
 * @author JueYue
 * @date 2013-9-28
 * @version 1.0
 */
public class Client implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private UserEntity user;

	//	private Map<String, TSFunction> functions;
	/**
	 * 用户IP
	 */
	private java.lang.String ip;
	/**
	 *登录时间
	 */
	private java.util.Date logindatetime;
	
	private List<ResourceEntity> menuList;
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public java.lang.String getIp() {
		return ip;
	}

	public void setIp(java.lang.String ip) {
		this.ip = ip;
	}

	public java.util.Date getLogindatetime() {
		return logindatetime;
	}

	public void setLogindatetime(java.util.Date logindatetime) {
		this.logindatetime = logindatetime;
	}

	public List<ResourceEntity> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<ResourceEntity> menuList) {
		this.menuList = menuList;
	}


}
