package cn.dinner.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.dao.MenuDao;
import cn.dinner.entity.Menu;
import cn.dinner.util.MenuCond;
import cn.dinner.util.Page;

public class MenuDaoImpl implements MenuDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Menu> menuList(Page page,MenuCond cond) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Menu where 1=1";
		if(cond.getM_name()!=null && !cond.getM_name().equals("")){
			hql += " and MName like :m_name";
		}
		if(cond.getM_type()!=null && cond.getM_type()!=-1){
			hql += " and menuType.id =:m_type";
		}
		String counthql = "select count(*)"+hql;
		Query query = session.createQuery(counthql);
		query.setProperties(cond);
		int count = ((Long)query.uniqueResult()).intValue();
		page.setCount(count);
		query = session.createQuery(hql+" order by id");
		query.setFirstResult((page.getPageIndex()-1)*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		query.setProperties(cond);
		List<Menu> menuList = query.list();
		return menuList;
	}

	@Override
	public int AddMenu(Menu menu) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(menu);
	}

	@Override
	public int delMenu(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from Menu where id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, id);
		return query.executeUpdate();
	}

	@Override
	public List<Menu> getMenuByTypeId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Menu where menuType.id=?");
		query.setInteger(0, id);
		return query.list();
	}

	@Override
	public Menu getMenuByid(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Menu where id=?");
		query.setInteger(0, id);
		return (Menu) query.list().get(0);
	}

	@Override
	public int updateMenu(Menu menu) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(menu);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

}
