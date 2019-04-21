package com.bjpowernode.common.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.bjpowernode.common.util.Pagination;

public interface BaseService {
	

	/**
	 * 
	 * @param entity
	 * @throws ValidateException 
	 */
	public <T> void saveOrUpdate(T entity);
	
	/**
	 * 根据主键获取对应实体信息
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> entityClass,String id);
	
	/**
	 * 后台数据查询
	 * @param condition
	 * @param page
	 * @param rows
	 * @return
	 */
	<T> Pagination<T> getPageData(DetachedCriteria condition, int page, int rows);
	
	/**
	 * 后台数据查询
	 * @param condition
	 * @return
	 */
	public <T> List<T> getQueryData(DetachedCriteria condition);
	
	/**
	 * 保存 entity
	 * 
	 * @param entity
	 * @throws ValidateException 
	 */
	public <T> void save(T entity);
	
	/**
	 * 保存 entity
	 * 
	 * @param entity
	 * @throws ValidateException 
	 */
	public <T> void saveBatch(List<T> entitys);
	
	/**
	 * 实体更新
	 * @param entity
	 * @throws Exception
	 */
	public <T> void update(T entity);
	
	/**
	 * 删除
	 * @param entity
	 * @throws Exception
	 */
	public <T> void delete(T entity);
}
