package com.bjpowernode.buss.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjpowernode.buss.entity.base.StudentEntity;
import com.bjpowernode.buss.service.StudentService;
import com.bjpowernode.common.dao.BaseDao;
import com.bjpowernode.common.util.Pagination;
import com.bjpowernode.system.service.impl.SystemServiceImpl;

@Service("studentService")
public class StudentServiceImpl extends SystemServiceImpl implements StudentService {
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public Pagination<StudentEntity> findPageData(DetachedCriteria condition,
			StudentEntity ce, int page, int rows) {
		Pagination<StudentEntity> pagination = new Pagination<StudentEntity>(page, rows);
		
		if(ce.getName() != null && !"".equals(ce.getName())){
			condition.add(Restrictions.like("name", "%"+ce.getName()+"%"));
		}
		if(ce.getQq() != null && !"".equals(ce.getQq())){
			condition.add(Restrictions.like("qq", "%"+ce.getQq()+"%"));
		}
		if(ce.getMobile() != null && !"".equals(ce.getMobile())){
			condition.add(Restrictions.like("mobile", "%"+ce.getMobile()+"%"));
		}
		if(ce.getStudentnum() != null && !"".equals(ce.getStudentnum())){
			condition.add(Restrictions.like("studentnum", "%"+ce.getStudentnum()+"%"));
		}
		condition.addOrder(Order.desc("createTime"));
		int total = this.baseDao.getRowCountByDetachedCriteria(condition);
		pagination.setTotalCount(total);
		condition.setProjection(null);
		if (total != 0) {
			List<StudentEntity> datas = baseDao.findByDetachedCriteria(condition, page, rows);
			pagination.setDatas(datas);
		}
		return pagination;
	}

}
