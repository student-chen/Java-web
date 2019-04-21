package com.bjpowernode.buss.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.bjpowernode.buss.entity.base.ScoreEntity;
import com.bjpowernode.common.util.Pagination;
import com.bjpowernode.system.service.SystemService;

public interface ScoreService extends SystemService {
	
	/**
	 * 根据传入数据进行查询
	 * @param condition
	 * @param ve
	 * @param page
	 * @param rows
	 * @return
	 */
	public Pagination<ScoreEntity> findPageData(DetachedCriteria condition,
			ScoreEntity ve, int page, int rows,String name,String teachername,String course,String term);
	
	public List<ScoreEntity> findData(DetachedCriteria condition,
			String name,String teachername,String coursename,String term) throws Exception;
}
