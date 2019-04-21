package com.bjpowernode.buss.service.impl;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjpowernode.buss.entity.base.ScoreEntity;
import com.bjpowernode.buss.service.ScoreService;
import com.bjpowernode.common.dao.BaseDao;
import com.bjpowernode.common.util.Pagination;
import com.bjpowernode.system.service.impl.SystemServiceImpl;

@Service("scoreService")
public class ScoreServiceImpl extends SystemServiceImpl implements ScoreService {
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public Pagination<ScoreEntity> findPageData(DetachedCriteria condition,
			ScoreEntity ce, int page, int rows,String name,String teachername,String coursename,String term) {
		Pagination<ScoreEntity> pagination = new Pagination<ScoreEntity>(page, rows);
		
		if(name != null && !"".equals(name)){
			condition.createAlias("studentEntity", "s");
			condition.add(Restrictions.like("s.name", "%"+name+"%"));
		}
		if(teachername != null && !"".equals(teachername)){
			condition.createAlias("teacherEntity", "t");
			condition.add(Restrictions.like("t.teachername", "%"+teachername+"%"));
		}
		if(coursename != null && !"".equals(coursename)){
			condition.add(Restrictions.like("coursename", "%"+coursename+"%"));
		}
		if(term != null && !"".equals(term)){
			condition.add(Restrictions.like("term", "%"+term+"%"));
		}
		condition.addOrder(Order.desc("createTime"));
		int total = this.baseDao.getRowCountByDetachedCriteria(condition);
		pagination.setTotalCount(total);
		condition.setProjection(null);
		if (total != 0) {
			List<ScoreEntity> datas = baseDao.findByDetachedCriteria(condition, page, rows);
			pagination.setDatas(datas);
		}
		return pagination;
	}
	
	@Override
	public List<ScoreEntity> findData(DetachedCriteria condition,
			String name,String teachername,String coursename,String term) throws Exception {
		
		List<ScoreEntity> scoreList = new ArrayList<ScoreEntity>();
		if(name != null && !"".equals(name)){
			name = URLDecoder.decode(name,"UTF-8");
			condition.createAlias("studentEntity", "s");
			condition.add(Restrictions.like("s.name", "%"+name+"%"));
		}
		if(teachername != null && !"".equals(teachername)){
			teachername = URLDecoder.decode(teachername,"UTF-8");
			condition.createAlias("teacherEntity", "t");
			condition.add(Restrictions.like("t.teachername", "%"+teachername+"%"));
		}
		if(coursename != null && !"".equals(coursename)){
			coursename = URLDecoder.decode(coursename,"UTF-8");
			condition.add(Restrictions.like("coursename", "%"+coursename+"%"));
		}
		if(term != null && !"".equals(term)){
			term = URLDecoder.decode(term,"UTF-8");
			condition.add(Restrictions.like("term", "%"+term+"%"));
		}
		condition.addOrder(Order.desc("createTime"));
		scoreList = this.baseDao.findByDetachedCriteriaNoPage(condition);
		
		return scoreList;
	}
}
