package com.sevenEleven.Beans;

/**
 * @author Tim
 *  class Bean 
 */
public class CclassBean {
     private long id;              //sequense自增长 班级代号
     private String name;            //班级名
     private String type;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
