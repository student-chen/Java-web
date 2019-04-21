package model;

import java.util.Collection;

public class PageBean {
	
	private Collection pbjs; //从数据库中读取数据
	private int totalCount;  //总条数 
	private int pageNo;   //当前页数
	private int pageCount; //每页条数
	public Collection getPbjs() {
		return pbjs;
	}
	public void setPbjs(Collection pbjs) {
		this.pbjs = pbjs;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	//总页数
	public int getTotalPage(){
		if(totalCount%pageCount==0){
			return totalCount/pageCount;
		}else{
			return totalCount/pageCount+1;
		}
	}
	
	//判断下一页的方法
	public boolean isNext(){
		return pageNo<getTotalPage();
	}
	
	//判断上一页
	public boolean isPrevious(){
		return pageNo>1;
	}
	public PageBean() {
		super();
		
	}
	public PageBean(Collection pbjs, int totalCount, int pageNo, int pageCount) {
		super();
		this.pbjs = pbjs;
		this.totalCount = totalCount;
		this.pageNo = pageNo;
		this.pageCount = pageCount;
	}
	
	
}
