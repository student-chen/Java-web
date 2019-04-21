package com.sevenEleven.Beans;


/**
 * @author Tim
 * teacher bean
 */
public class CteacherBean {
	private long t_id;                //sequense 自增长
	private java.lang.String t_number;              //工号       not null
	private java.lang.String t_name;         //老师姓名   not null
	private java.lang.String t_password;     //老师密码   not null
	private java.lang.String t_skill;		   //老师技能      
	//set
	public void setT_id(long id){
		this.t_id = id;
	}
	public void setT_number(java.lang.String t_number){
		this.t_number = t_number;
	}
	public void setT_name(java.lang.String t_name){
		this.t_name = t_name;
	}
	public void setT_password(java.lang.String t_password){
		this.t_password = t_password;
	}
	public void setSkill(java.lang.String skill){
		this.t_skill = skill;
	}
	//get
	public long getT_id(){
		return this.t_id;
	}
	public java.lang.String getT_number(){
		return this.t_number;
	}
	public java.lang.String getT_name(){
		return this.t_name;
	}
	public java.lang.String getT_password(){
		return this.t_password;
	}
	public java.lang.String getSkill(){
		return this.t_skill;
	}
}
