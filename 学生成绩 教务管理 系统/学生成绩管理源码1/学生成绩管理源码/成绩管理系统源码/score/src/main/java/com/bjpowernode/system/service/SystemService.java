package com.bjpowernode.system.service;

import java.util.List;

import com.bjpowernode.common.service.BaseService;
import com.bjpowernode.system.entity.base.ResourceEntity;
import com.bjpowernode.system.entity.base.UserEntity;



public interface SystemService extends BaseService{

	public UserEntity getUserByNameAndPassword(UserEntity user);
	
	public List<ResourceEntity> getTreeMenuResource(UserEntity user);
	
	public String getTreeJson(List<ResourceEntity> list);
	
	public <T> T findUniqueByProperty(Class<T> entityClass,
			String propertyName, Object value);
	
}
