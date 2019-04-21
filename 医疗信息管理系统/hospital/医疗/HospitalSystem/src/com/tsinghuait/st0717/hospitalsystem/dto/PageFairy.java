package com.tsinghuait.st0717.hospitalsystem.dto;

public class PageFairy {
    private int nextpage; //下一页的条数
    private int priorPage;//待显页的显示条数
    private int rowsCount;//纪录总条数
    private int pageCount;//一页显示的条数
    private int page;
    public static int numberpage=2;//一页显示条数
	public int getNextpage() {
		return nextpage;
	}
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPriorPage() {
		return priorPage;
	}
	public void setPriorPage(int priorPage) {
		this.priorPage = priorPage;
	}
	public int getRowsCount() {
		return rowsCount;
	}
	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}
}
