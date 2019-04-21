package cn.dinner.util;

public class UserCond {
	
	private String name;
	private Integer mtype;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMtype() {
		return mtype;
	}
	public void setMtype(Integer mtype) {
		this.mtype = mtype;
	}
	public UserCond() {
		//super();
	}
	public UserCond(String name, Integer mtype) {
		//super();
		this.name = name;
		this.mtype = mtype;
	}
	
	
}
