package com.bjpowernode.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.common.service.impl.BaseServiceImpl;
import com.bjpowernode.system.dao.SystemDao;
import com.bjpowernode.system.entity.base.ResourceEntity;
import com.bjpowernode.system.entity.base.UserEntity;
import com.bjpowernode.system.service.SystemService;

@Service("systemService")
public class SystemServiceImpl extends BaseServiceImpl implements SystemService {
	
	@Autowired
	private SystemDao systemDao;
	
	@Override
	public UserEntity getUserByNameAndPassword(UserEntity user) {
		
		return systemDao.getUserByNameAndPassword(user);
	}

	@Override
	public List<ResourceEntity> getTreeMenuResource(UserEntity user) {
		return systemDao.getTreeMenuResource(user);
	}

	@Override
	public String getTreeJson(List<ResourceEntity> list) {
		
		return createTreeJson(list);
	}
	
	private String createTreeJson(List<ResourceEntity> list) {
	    JSONArray rootArray = new JSONArray();
	    for (int i=0; i<list.size(); i++) {
	    	ResourceEntity resource = list.get(i);
	      if (resource.getParentResource() == null) {
	        JSONObject rootObj = createBranch(list, resource);
	        rootArray.add(rootObj);
	      }
	    }
	    
	    return rootArray.toString();
	  }
	  
	  /**
	   * 递归创建分支节点Json对象
	   * @param list 创建树的原始数据
	   * @param currentNode 当前节点
	   * @return 当前节点与该节点的子节点json对象
	   */
	  private JSONObject createBranch(List<ResourceEntity> list, ResourceEntity currentNode) {
	    /*
	     * 将javabean对象解析成为JSON对象
	     */
	    JSONObject currentObj = JSONObject.parseObject(JSON.toJSONString(currentNode));
	    JSONArray childArray = new JSONArray();
	    /*
	     * 循环遍历原始数据列表，判断列表中某对象的父id值是否等于当前节点的id值，
	     * 如果相等，进入递归创建新节点的子节点，直至无子节点时，返回节点，并将该
	     * 节点放入当前节点的子节点列表中
	     */
	    for (int i=0; i<list.size(); i++) {
	    	ResourceEntity newNode = list.get(i);
	      if (newNode.getParentResource()!=null && currentNode.getId().equals(newNode.getParentResource().getId())) {
	        JSONObject childObj = createBranch(list, newNode);
	        childArray.add(childObj);
	      }
	    }
	    
	    /*
	     * 判断当前子节点数组是否为空，不为空将子节点数组加入children字段中
	     */
	    if (!childArray.isEmpty()) {
	      currentObj.put("children", childArray);
	    }
	    
	    return currentObj;
	  }
	  
	  public <T> T findUniqueByProperty(Class<T> entityClass,
				String propertyName, Object value) {
			return systemDao.findUniqueByProperty(entityClass, propertyName, value);
		}

}
