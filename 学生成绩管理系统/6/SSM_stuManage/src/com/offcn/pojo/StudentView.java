package com.offcn.pojo;

/**
 * <p>Company: offcn</p>
 * @author zgf
 * @date 2017年6月3日
 * @version 1.0
 */
public class StudentView extends Student {
   private String classname;
   private String couname;
   private Integer cid;

	public String getClassname() {
		return classname;
	}
	
	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getCouname() {
		return couname;
	}

	public void setCouname(String couname) {
		this.couname = couname;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
   
}
