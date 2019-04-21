package com.tsinghuait.st0717.hospitalsystem.dto;

public class PagePagination {
	/**
	 *  定义分页类,对数据进行分页
	 */
	private int pageCount;//总页数
	private int pageSize;//当前页数
	private int priorPage;//上一页
	private int nextPage;//下一页
	private int lastPage;//末页
	private int pageNum;//共有多少数据
	private String currentType;
	private String isActive;
	
	
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPriorPage() {
		return priorPage;
	}
	public void setPriorPage(int priorPage) {
		this.priorPage = priorPage;
	}
	public String getCurrentType() {
		return currentType;
	}
	public void setCurrentType(String currentType) {
		this.currentType = currentType;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
}
