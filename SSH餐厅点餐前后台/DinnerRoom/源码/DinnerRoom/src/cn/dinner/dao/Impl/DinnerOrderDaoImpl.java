package cn.dinner.dao.Impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.dinner.dao.DinnerOrderDao;
import cn.dinner.entity.DinnerOrder;
import cn.dinner.util.DinnerOrderCond;
import cn.dinner.util.Page;

public class DinnerOrderDaoImpl implements DinnerOrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<DinnerOrder> getAllDinnerOrder(Page page, DinnerOrderCond cond) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from DinnerOrder where 1=1";
		if(cond.getId()!=null){
			hql += " and id=:id";
		}
		if(cond.getStartTime()!=null && !cond.getStartTime().equals("")){
			hql += " and ordertime between :startTime and :endTime";
		}
		String counthql = "select count(*) "+hql;
		Query query = session.createQuery(counthql);
		query.setProperties(cond);
		int count = ((Long)query.uniqueResult()).intValue();
		page.setCount(count);
		query = session.createQuery(hql+" order by ispay,ordertime");
		query.setFirstResult((page.getPageIndex()-1)*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		query.setProperties(cond);
		return query.list();
	}

	@Override
	public int delOrderInfo(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "delete from DinnerOrder where id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, id);
		return query.executeUpdate();
	}

	@Override
	public List<DinnerOrder> getAllDinnerOrderByhouchu(Page page) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from DinnerOrder where isFull=0";
		String counthql = "select count(*) "+hql;
		Query query = session.createQuery(counthql);
		int count = ((Long)query.uniqueResult()).intValue();
		page.setCount(count);
		query = session.createQuery(hql+" order by ordertime");
		query.setFirstResult((page.getPageIndex()-1)*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		return query.list();
	}

	@Override
	public int UpdateisFull(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update DinnerOrder set isFull=1 where id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, id);
		return query.executeUpdate();
	}

	@Override
	public int addOrder(DinnerOrder order) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer) session.save(order);
	}

	@Override
	public List<DinnerOrder> getAllDinnerOrderByQT(Page page,
			DinnerOrderCond cond) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from DinnerOrder where 1=1";
		if(cond.getIspay()!=null && cond.getIspay()!=-1){
			hql += " and ispay=:ispay";
		}
		if(cond.getStartTime()!=null && !cond.getStartTime().equals("")){
			hql += " and ordertime between :startTime and :endTime";
		}
		String counthql = "select count(*) "+hql;
		Query query = session.createQuery(counthql);
		query.setProperties(cond);
		int count = ((Long)query.uniqueResult()).intValue();
		page.setCount(count);
		query = session.createQuery(hql+" order by ispay,ordertime");
		query.setFirstResult((page.getPageIndex()-1)*page.getPageSize());
		query.setMaxResults(page.getPageSize());
		query.setProperties(cond);
		return query.list();
	}

	@Override
	public int updateOrder(Integer oid, Double price) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "update DinnerOrder set ispay=1,price=? where id=?";
		Query query = session.createQuery(hql);
		query.setDouble(0, price);
		query.setInteger(1, oid);
		return query.executeUpdate();
	}

	@Override
	public String homeInfo() {
		Session session = sessionFactory.getCurrentSession();
		String info="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df = DateFormat.getDateInstance();//日期格式，精确到日
		Calendar calendar = Calendar.getInstance();
		//昨天时间（年月日）
        Date yesterday =new Date();
        calendar.setTime(yesterday);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        yesterday = calendar.getTime();
       
        //明天时间（年月日）
        Date tomorrow =new Date();
        calendar.setTime(tomorrow);
        calendar.add(Calendar.DAY_OF_MONTH, +1);
        tomorrow=calendar.getTime();

        Double SR;   //收入
        Integer JDPersonNum;  //接待人数
        Integer OrderNum;  //订单数目
        Integer personNum;  //各个时间范围人流量变量
        String hql = "from DinnerOrder where ordertime between ? and ?";//昨日今日复用hql
        String hqlper = "select sum(personnum) from DinnerOrder";//人流量复用hql
        
        //昨日报表
        //1.昨日收入
        Query query = session.createQuery("select sum(price) "+hql);
        try {
			query.setDate(0, sdf.parse(df.format(yesterday)));
			query.setDate(1, sdf.parse(df.format(new Date())));
			SR = ((Double)query.uniqueResult()).doubleValue();
		} catch (Exception e) {
			SR = 0.0;
		}
        info += info+SR;
        
        //2.昨日接待人数
        query = session.createQuery("select sum(personnum) "+hql);
        try {
        	query.setDate(0, sdf.parse(df.format(yesterday)));
			query.setDate(1, sdf.parse(df.format(new Date())));
			JDPersonNum = ((Long)query.uniqueResult()).intValue();
		} catch (Exception e) {
			JDPersonNum = 0;
		}
        info += ","+JDPersonNum;
        
        //3.昨日订单数目
        query = session.createQuery("select count(id) "+hql);
        try {
        	query.setDate(0, sdf.parse(df.format(yesterday)));
			query.setDate(1, sdf.parse(df.format(new Date())));
			OrderNum = ((Long)query.uniqueResult()).intValue();
		} catch (Exception e) {
			OrderNum = 0;
		}
        info += ","+OrderNum;
        
        //今日报表
        //1.今日收入
        query = session.createQuery("select sum(price) "+hql);
        try {
			query.setDate(0, sdf.parse(df.format(new Date())));
			query.setDate(1, sdf.parse(df.format(tomorrow)));
			SR = ((Double)query.uniqueResult()).doubleValue();
		} catch (Exception e) {
			SR = 0.0;
		}
        info += ","+SR;
        
        //2.今日接待人数
        query = session.createQuery("select sum(personnum) "+hql);
        try {
        	query.setDate(0, sdf.parse(df.format(new Date())));
			query.setDate(1, sdf.parse(df.format(tomorrow)));
			JDPersonNum = ((Long)query.uniqueResult()).intValue();
		} catch (Exception e) {
			JDPersonNum = 0;
		}
        info += ","+JDPersonNum;
        
        //3.今日订单数目
        query = session.createQuery("select count(id) "+hql);
        try {
        	query.setDate(0, sdf.parse(df.format(new Date())));
			query.setDate(1, sdf.parse(df.format(tomorrow)));
			OrderNum = ((Long)query.uniqueResult()).intValue();
		} catch (Exception e) {
			OrderNum = 0;
		}
        info += ","+OrderNum;
        
        //人流量
        //8：00 - 10：00
        query = session.createQuery(hqlper+" where ordertime between '"+df.format(new Date())+" 8:00' and '"+df.format(new Date())+" 10:00'");
        try {
        	personNum = ((Long)query.uniqueResult()).intValue();
		} catch (Exception e) {
			personNum = 0;
		}
        info += ","+personNum;
        //10：00 - 14：00
        query = session.createQuery(hqlper+" where ordertime between '"+df.format(new Date())+" 10:00' and '"+df.format(new Date())+" 14:00'");
        try {
        	personNum = ((Long)query.uniqueResult()).intValue();
		} catch (Exception e) {
			personNum = 0;
		}
        info += ","+personNum;
        //17：00 - 19：00
        query = session.createQuery(hqlper+" where ordertime between '"+df.format(new Date())+" 17:00' and '"+df.format(new Date())+" 19:00'");
        try {
        	personNum = ((Long)query.uniqueResult()).intValue();
		} catch (Exception e) {
			personNum = 0;
		}
        info += ","+personNum;
        //19：00 - 23：59
        query = session.createQuery(hqlper+" where ordertime between '"+df.format(new Date())+" 19:00' and '"+df.format(new Date())+" 23:59'");
        try {
        	personNum = ((Long)query.uniqueResult()).intValue();
		} catch (Exception e) {
			personNum = 0;
		}
        info += ","+personNum;
        return info;
	}

}
