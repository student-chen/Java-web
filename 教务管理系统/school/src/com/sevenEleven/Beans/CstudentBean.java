/**
 * 
 */
package com.sevenEleven.Beans;

/**
 * @author Administrator
 * 
 */
public class CstudentBean {
	private long s_id; // sequense 自增长

	private java.lang.String s_number; // 学号 not null

	private java.lang.String s_name; // 学生姓名 not null

	private java.lang.String s_password; // 学生密码 not null
	
	private String c_name;

	private String c_type;

	//private char sex; // 学生姓别

	//private java.lang.String grade; // 学生年级

	//private java.lang.String major; // 学生专业

	private long c_id; // 学生班级 not null

	public long getC_id() {
		return c_id;
	}

	public void setC_id(long c_id) {
		this.c_id = c_id;
	}

	public long getS_id() {
		return s_id;
	}

	public void setS_id(long s_id) {
		this.s_id = s_id;
	}

	public java.lang.String getS_name() {
		return s_name;
	}

	public void setS_name(java.lang.String s_name) {
		this.s_name = s_name;
	}

	public java.lang.String getS_number() {
		return s_number;
	}

	public void setS_number(java.lang.String s_number) {
		this.s_number = s_number;
	}

	public java.lang.String getS_password() {
		return s_password;
	}

	public void setS_password(java.lang.String s_password) {
		this.s_password = s_password;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}

	
	
}
