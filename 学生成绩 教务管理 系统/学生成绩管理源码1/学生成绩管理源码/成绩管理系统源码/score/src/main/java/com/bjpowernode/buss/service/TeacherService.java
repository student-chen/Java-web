package com.bjpowernode.buss.service;

import org.hibernate.criterion.DetachedCriteria;

import com.bjpowernode.buss.entity.base.TeacherEntity;
import com.bjpowernode.common.util.Pagination;
import com.bjpowernode.system.service.SystemService;

public interface TeacherService extends SystemService {
	
	/**
	 * 根据传入数据进行查询
	 * @param condition
	 * @param ve
	 * @param page
	 * @param rows
	 * @return
	 */
	public Pagination<TeacherEntity> findPageData(DetachedCriteria condition,
			TeacherEntity ve, int page, int rows);
}
