package com.bjpowernode.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页实体信息
 * @author Administrator
 *
 * @param <E>
 */
public class Pagination<E> {
   
	public Pagination() {

	}

	public Pagination(int start, int pageSize) {
		this.start = start;
		this.pageSize = pageSize;
	}

	/**
	 * 开始页数
	 */
	private int start;

	/**
	 * 总条数
	 */
	private int totalCount;

	/**
	 * 复合条件的实体对应信息
	 */
	private List<E> datas;
	
	
	/**
	 * 一页默认的数据条数
	 */
	private int pageSize = 10;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<E> getDatas() {
		return datas== null? new ArrayList<E>(): datas;
	}

	public void setDatas(List<E> datas) {
		this.datas = datas;
	}
}