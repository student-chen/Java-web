package com.bjpowernode.buss.service;

import org.hibernate.criterion.DetachedCriteria;

import com.bjpowernode.buss.entity.base.StudentEntity;
import com.bjpowernode.common.util.Pagination;
import com.bjpowernode.system.service.SystemService;

public interface StudentService extends SystemService {
	
	/**
	 * 根据传入数据进行查询
	 * @param condition
	 * @param ce
	 * @param page
	 * @param rows
	 * @return
	 */
	public Pagination<StudentEntity> findPageData(DetachedCriteria condition,
			StudentEntity ce, int page, int rows);
}
