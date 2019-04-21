package com.bjpowernode.system.vo;

import java.util.ArrayList;
import java.util.List;

import com.bjpowernode.common.util.Pagination;

public class Data<T> {

	private Pagination<T> pagination;
	
	public Data(Pagination<T> pagination) {
		this.pagination = pagination;
	}

	private int total;
	
	private List<T> rows = new ArrayList<T>();
	
	public int getTotal() {
		return this.pagination.getTotalCount();
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public List<T> getRows() {
		return this.pagination.getDatas();
	}
	
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
