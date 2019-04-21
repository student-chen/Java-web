package cn.dinner.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.dao.MemberDao;
import cn.dinner.entity.Member;
import cn.dinner.util.MemberCond;
import cn.dinner.util.Page;

public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Member> getAllByPage(Page page, MemberCond cond) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Member where 1=1";
		if(cond.getPhone()!=null && !cond.getPhone().equals("")){
			hql += " and phone like :phone";
		}
		if(cond.getMembertypeid()!=null && cond.getMembertypeid()!=-1){
			hql += " and memberType.id =:membertypeid";
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
		return query.list();
	}

	@Override
	public Member getMemberByid(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Member where id=?");
		query.setInteger(0, id);
		return (Member) query.list().get(0);
	}

	@Override
	public int UpdateMember(Member member) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(member);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int delMember(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Member where id=?");
		query.setInteger(0, id);
		return query.executeUpdate();
	}

	@Override
	public List<Member> getAllByMemberTypeId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Member where memberType.id=?");
		query.setInteger(0, id);
		return query.list();
	}

	@Override
	public int AddMember(Member member) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(member);
	}

	@Override
	public int flagMemberByphone(String phone) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Member where phone=?";
		Query query = session.createQuery(hql);
		query.setString(0, phone);
		return ((Long)query.uniqueResult()).intValue();
	}

	@Override
	public int UpdateMemberByphone(String phone, Integer code) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update Member set mcode=mcode+? where phone=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, code);
		query.setString(1, phone);
		return query.executeUpdate();
	}

}
