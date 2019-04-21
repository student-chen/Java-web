package cn.dinner.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.dao.DinnerNoticeDao;
import cn.dinner.entity.DinnerNotice;

public class DinnerNoticeDaoImpl implements DinnerNoticeDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<DinnerNotice> getAllDinnerNoticeByID(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from DinnerNotice where orderId=? order by id");
		query.setInteger(0, id);
		return query.list();
	}

	@Override
	public int delNotice(Integer oid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from DinnerNotice where orderId=?");
		query.setInteger(0, oid);
		return query.executeUpdate();
	}

	@Override
	public int addNotice(DinnerNotice notice) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(notice);
	}

}
