
package com.sevenEleven.Beans;

/**
 * @author Tim
 * admin Bean
 */
public class CadminBean {
	private long a_id;               //sequense自增长
	private String a_name;          //管理员姓名
	private String a_password;      //管理员密码
	private long a_type;         //管理员类型1.总管理员 2.校务管理员 3.图书馆理员 4.BBS管理员
	//set                                               	
	public long getA_id() {
		return a_id;
	}
	public void setA_id(long a_id) {
		this.a_id = a_id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_password() {
		return a_password;
	}
	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	public long getA_type() {
		return a_type;
	}
	public void setA_type(long a_type) {
		this.a_type = a_type;
	}

}
