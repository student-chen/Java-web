package com.bjpowernode.system.dao.impl;

import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bjpowernode.common.dao.impl.BaseDaoImpl;
import com.bjpowernode.system.dao.SystemDao;
import com.bjpowernode.system.entity.base.ResourceEntity;
import com.bjpowernode.system.entity.base.UserEntity;

@Repository
public class SystemDaoImpl extends BaseDaoImpl implements SystemDao {

	@Override
	public UserEntity getUserByNameAndPassword(UserEntity user) {
		Md5Hash md5Hash = new Md5Hash(user.getPassword());
		String password = md5Hash.toHex();
		String query = "from UserEntity u where u.username = :username and u.password=:passowrd";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("username", user.getUsername());
		queryObject.setParameter("passowrd", password);
		List<UserEntity> users = queryObject.list();
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		
		return null;
	}
	
	/**
	 * 获取用户左侧权限菜单
	 */
	@Override
	public List<ResourceEntity> getTreeMenuResource(UserEntity user) {
		String hql = "select r.resource from UserEntity u inner join fecth u.roles r where u.id = :id";
		Query queryObject = getSession().createQuery(hql);
		queryObject.setParameter("id", user.getId());
		List<ResourceEntity> resourceList = queryObject.list();
		
		return resourceList;
	}
	
	public <T> T findUniqueByProperty(Class<T> entityClass,
			String propertyName, Object value) {
		return (T) createCriteria(entityClass,
				Restrictions.eq(propertyName, value)).uniqueResult();
	}
	
	private <T> Criteria createCriteria(Class<T> entityClass,
			Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}
}
