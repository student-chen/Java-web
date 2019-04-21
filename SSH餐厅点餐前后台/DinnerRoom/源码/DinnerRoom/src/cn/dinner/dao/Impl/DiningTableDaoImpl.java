package cn.dinner.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.dao.DiningTableDao;
import cn.dinner.entity.DiningTable;
import cn.dinner.util.Page;

public class DiningTableDaoImpl implements DiningTableDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<DiningTable> getdiningTableByPage(Page page) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from DiningTable where 1=1";
		String counthql = "select count(*) "+hql;
		Query query = session.createQuery(counthql);
		int count = ((Long)query.uniqueResult()).intValue();
		page.setCount(count);
		query = session.createQuery(hql+" order by id");
		query.setFirstResult((page.getPageIndex()-1)*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		return query.list();
	}

	@Override
	public int UpdateDiningTable(DiningTable dt) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(dt);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int delDiningTable(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from DiningTable where id=?");
		query.setInteger(0, id);
		return query.executeUpdate();
	}

	@Override
	public int addDiningTable(DiningTable dt) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(dt);
	}

	@Override
	public DiningTable getOneTable(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from DiningTable where id=?");
		query.setInteger(0, id);
		return (DiningTable) query.list().get(0);
	}

	@Override
	public int flagTableNum(String tableNum) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from DiningTable where tableNum=?");
		query.setString(0, tableNum);
		return ((Long)query.uniqueResult()).intValue();
	}

	@Override
	public List<DiningTable> getAlldiningTable() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from DiningTable where isno=0 order by id");
		return query.list();
	}

	@Override
	public int updateTableIsNo(Integer tabId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update DiningTable set isno=1 where id=?");
		query.setInteger(0, tabId);
		return query.executeUpdate();
	}

	@Override
	public int updateTableIsOff(Integer tabId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update DiningTable set isno=0 where id=?");
		query.setInteger(0, tabId);
		return query.executeUpdate();
	}

	@Override
	public DiningTable getOneTableBytabNum(String tabNum) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from DiningTable where tableNum=?");
		query.setString(0, tabNum);
		return (DiningTable) query.list().get(0);
	}

	@Override
	public List<DiningTable> getdiningTable() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from DiningTable where isno=1 order by id");
		return query.list();
	}

}
