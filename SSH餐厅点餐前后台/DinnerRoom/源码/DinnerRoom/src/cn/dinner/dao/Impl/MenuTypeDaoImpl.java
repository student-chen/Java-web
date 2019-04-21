package cn.dinner.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.dao.MenuTypeDao;
import cn.dinner.entity.MenuType;
import cn.dinner.util.Page;

public class MenuTypeDaoImpl implements MenuTypeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<MenuType> getAllMenuType() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MenuType order by id");
		return query.list();
	}

	@Override
	public MenuType getOne(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from MenuType where id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, id);
		return (MenuType) query.list().get(0);
	}

	@Override
	public List<MenuType> getAllMenuTypeBypage(Page page) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from MenuType";
		String counthql = "select count(*)"+hql;
		Query query = session.createQuery(counthql);
		int count = ((Long)query.uniqueResult()).intValue();
		page.setCount(count);
		query = session.createQuery(hql+" order by id");
		query.setFirstResult((page.getPageIndex()-1)*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		List<MenuType> menuTypeList = query.list();
		return menuTypeList;
	}

	@Override
	public int addMenuType(MenuType menuType) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(menuType);
	}

	@Override
	public int getOneByname(String name) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from MenuType where typeName=?";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		return ((Long)query.uniqueResult()).intValue();
	}

	@Override
	public int delMenuType(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from MenuType where id=?");
		query.setInteger(0, id);
		return query.executeUpdate();
	}

}
