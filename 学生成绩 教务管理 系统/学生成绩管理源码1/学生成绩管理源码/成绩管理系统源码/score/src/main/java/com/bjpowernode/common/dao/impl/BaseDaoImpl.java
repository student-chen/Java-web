package com.bjpowernode.common.dao.impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bjpowernode.common.dao.BaseDao;

@Repository("baseDao")
public class BaseDaoImpl implements BaseDao {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}
	
	

	@Override
	public <T> void saveOrUpdate(T entity){
		try{
			this.getSession().saveOrUpdate(entity);
			this.getSession().flush();
		}catch(RuntimeException e){
			logger.error("保存或更新实体异常",e);
			throw e;
		}
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(Class<T> entityClass, String id) {
		return (T) this.getSession().get(entityClass, id);
	}

	@Override
	public int getRowCountByDetachedCriteria(DetachedCriteria condition) {
		Criteria criteria = condition.getExecutableCriteria(this.getSession());
		Long totalCount = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		return totalCount == null ? 0 : totalCount.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findByDetachedCriteria(DetachedCriteria condition, int page, int rows) {
		Criteria criteria = condition.getExecutableCriteria(this.getSession());
		criteria.setFirstResult((page - 1) * rows).setMaxResults(rows);
		criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findByDetachedCriteriaNoPage(DetachedCriteria condition) {
		Criteria criteria = condition.getExecutableCriteria(this.getSession());
		return criteria.list();
	}
	
	@Override
	public <T> void save(T entity) {
		try{
			this.getSession().save(entity);
			this.getSession().flush();
		}catch(RuntimeException e){
			logger.error("保存实体异常",e);
			throw e;
		}
	}

	@Override
	public <T> void update(T entity){
		try{
			this.getSession().update(entity);
			this.getSession().flush();
		}catch(RuntimeException e){
			logger.error("更新实体异常",e);
			throw e;
		}
	}

	@Override
	public <T> void delete(T entity) {
		try{
			this.getSession().delete(entity);
			this.getSession().flush();
		}catch(RuntimeException e){
			logger.error("删除实体异常",e);
			throw e;
		}
	}


}
