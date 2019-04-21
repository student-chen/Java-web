package com.bjpowernode.common.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bjpowernode.common.dao.BaseDao;
import com.bjpowernode.common.service.BaseService;
import com.bjpowernode.common.util.Pagination;

@Service("baseService")
public class BaseServiceImpl implements BaseService{
	
	@Autowired
	@Qualifier("baseDao") 
	private BaseDao baseDao;
	
	/**
	 * 注入一个sessionFactory属性,并注入到父类(HibernateDaoSupport)
	 * **/
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	@Override
	public <T> void saveOrUpdate(T entity){
		this.baseDao.saveOrUpdate(entity);
	}

	@Override
	public <T> T get(Class<T> entityClass,String id) {
		return this.baseDao.get(entityClass,id);
	}


	@Override
	public <T> Pagination<T> getPageData(DetachedCriteria condition, int page, int rows) {
		Pagination<T> pagination = new Pagination<T>(page, rows);
		
		int total = this.baseDao.getRowCountByDetachedCriteria(condition);
		pagination.setTotalCount(total);
		
		condition.setProjection(null);

		if (total != 0) {
			List<T> datas = this.baseDao.findByDetachedCriteria(condition, page, rows);
			
			pagination.setDatas(datas);
		}
		return pagination;
	}

	@Override
	public <T> List<T> getQueryData(DetachedCriteria condition) {
		List<T> resultList = this.baseDao.findByDetachedCriteriaNoPage(condition);
		return resultList;
	}
	
	@Override
	public <T> void save(T entity){
		this.baseDao.save(entity);
	}

	@Override
	public <T> void update(T entity) {
		this.baseDao.update(entity);
	}


	@Override
	public <T> void delete(T entity){
		this.baseDao.delete(entity);
	}

	@Override
	public <T> void saveBatch(List<T> entitys) {
		for (int i = 0; i < entitys.size(); i++) {
			Object object = entitys.get(i);
			getSession().save(object);
			if (i % 20 == 0) {
				// 20个对象后才清理缓存，写入数据库
				getSession().flush();
				getSession().clear();
			}
		}
		// 最后清理一下----防止大于20小于40的不保存
		getSession().flush();
		getSession().clear();
	}


}
