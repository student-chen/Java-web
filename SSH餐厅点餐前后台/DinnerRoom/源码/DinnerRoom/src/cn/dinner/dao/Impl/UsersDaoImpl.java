package cn.dinner.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.dao.UsersDao;
import cn.dinner.entity.Users;
import cn.dinner.util.Page;
import cn.dinner.util.UserCond;

public class UsersDaoImpl implements UsersDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Users LoginUser(String loginName) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from Users where ULoginname=?";
			Query query = session.createQuery(hql);
			query.setString(0, loginName);
			 Users user = (Users)query.list().get(0);
			 return user;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Users> getAllUsers(Page page,UserCond cond) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Users where 1=1";
		if(cond.getName()!=null && !cond.getName().equals("")){
			hql += " and UName like :name";
		}
		if(cond.getMtype()!=null && cond.getMtype()!=-1){
			hql += " and URole =:mtype";
		}
		String conthql = "select count(*)"+hql;
		Query query = session.createQuery(conthql);
		query.setProperties(cond);
		int count = ((Long)query.uniqueResult()).intValue();
		page.setCount(count);
		int totalPage = (count%page.getPageSize()==0)?(count/page.getPageSize()):(count/page.getPageSize()+1);
		page.setTotalPage(totalPage);
		query = session.createQuery(hql+" order by id");
		query.setFirstResult((page.getPageIndex()-1)*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		query.setProperties(cond);
		List<Users> list = query.list();
		return list;
	}

	@Override
	public int delUser(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Users where id=?");
		query.setInteger(0, id);
		return query.executeUpdate();
	}

	@Override
	public int UpdateUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(user);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int addUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(user);
	}

	@Override
	public Users getOneuser(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Users where id=?");
		query.setInteger(0, id);
		return (Users) query.list().get(0);
	}

	@Override
	public int flagLoginName(String loginName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from Users where ULoginname=?");
		query.setString(0, loginName);
		return ((Long)query.uniqueResult()).intValue();
	}

	@Override
	public int UpUserPwd(Integer uid, String pwd) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Users set UPwd=? where id=?");
		query.setString(0, pwd);
		query.setInteger(1, uid);
		return query.executeUpdate();
	}

	@Override
	public int UpdateUserOnline(String loginName,Integer onlineNo) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Users set uonline=? where ULoginname=?");
		query.setInteger(0, onlineNo);
		query.setString(1, loginName);
		return query.executeUpdate();
	}
}
