package cn.dinner.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.dao.MemberTypeDao;
import cn.dinner.entity.MemberType;
import cn.dinner.util.Page;

public class MemberTypeDaoImpl implements MemberTypeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<MemberType> getAllMemberType() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MemberType order by id");
		return query.list();
	}

	@Override
	public MemberType getOneMemberType(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MemberType where id=?");
		query.setInteger(0, id);
		return (MemberType) query.list().get(0);
	}

	@Override
	public List<MemberType> getAllMemberTypeByPage(Page page) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from MemberType where 1=1";
		String counthql = "select count(*)"+hql;
		Query query = session.createQuery(counthql);
		int count = ((Long)query.uniqueResult()).intValue();
		page.setCount(count);
		query = session.createQuery(hql+" order by id");
		query.setFirstResult((page.getPageIndex()-1)*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		return query.list();
	}

	@Override
	public int flagMemberType(String typename) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from MemberType where typeName=?";
		Query query = session.createQuery(hql);
		query.setString(0, typename);
		return ((Long)query.uniqueResult()).intValue();
	}

	@Override
	public int addMemberType(MemberType mt) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(mt);
	}

	@Override
	public int delMemberType(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from MemberType where id=?");
		query.setInteger(0, id);
		return query.executeUpdate();
	}

}
