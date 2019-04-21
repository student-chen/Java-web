package com.bjpowernode.common.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao {

	/**
	 * 保存/更新
	 * @param entity
	 * @throws ValidateException 
	 */
	public <T> void saveOrUpdate(T entity);
	
	/**
	 * 根据主键id 获取对应实体信息
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> entityClass, String id);
	
	/**
	 * 根据入参参数类型获取到复合条件的所有实体信息条数
	 * @param condition
	 * @return
	 */
	public int getRowCountByDetachedCriteria(DetachedCriteria condition);

	/**
	 * 根据入参参数类型获取到复合条件的所有实体信息list集合
	 * @param condition
	 * @param page
	 * @param rows
	 * @return
	 */
	public <T> List<T> findByDetachedCriteria(DetachedCriteria condition, int page, int rows);
	
	/**
	 * 根据入参参数类型获取到复合条件的所有实体信息list集合
	 * @param condition
	 * @return
	 */
	public <T> List<T> findByDetachedCriteriaNoPage(DetachedCriteria condition);
	/**
	 * 实体保存
	 * @param entity
	 * @throws Exception
	 */
	public <T> void save(T entity);
	
	/**
	 * 实体更新
	 * @param entity
	 * @throws Exception
	 */
	public <T> void update(T entity);
	
	/**
	 * 删除
	 * @param idArray
	 * @throws Exception
	 */
	public <T> void delete(T entity);

}
