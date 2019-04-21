package com.student.pojo;

import java.util.List;
import java.util.Map;

public class PagerMySQL<T> {
	private int pageNo;
	private int pageSize;
	private int totalSize;
	private int totalPage;
	private boolean hasPrev;
	private boolean hasNext;
	
	private List<T> entitiesList;
	private Map<String, Object> conditions;
	
	private int beginIndex;
	
	public PagerMySQL(int pageNo, int pageSize, int totalSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		
		
		this.beginIndex = (this.pageNo - 1) * this.pageSize;
		
		this.totalSize = totalSize;
		this.totalPage = totalSize % pageSize == 0 ? totalSize / pageSize : totalSize / pageSize + 1;
		
		this.hasPrev = pageNo==1?false:true;
		this.hasNext = pageNo==totalPage?false:true;
	}

	public int getPageNo() {
		return pageNo;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public boolean isHasPrev() {
		return hasPrev;
	}

	public boolean isHasNext() {
		return hasNext;
	}

	public List<T> getEntitiesList() {
		return entitiesList;
	}

	public void setEntitiesList(List<T> entitiesList) {
		this.entitiesList = entitiesList;
	}

	public Map<String, Object> getConditions() {
		return conditions;
	}

	public void setConditions(Map<String, Object> conditions) {
		this.conditions = conditions;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

}
