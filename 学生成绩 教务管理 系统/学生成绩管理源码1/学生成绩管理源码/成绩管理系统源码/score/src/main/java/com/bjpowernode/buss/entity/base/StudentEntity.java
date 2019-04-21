package com.bjpowernode.buss.entity.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bjpowernode.common.entity.base.BaseEntity;

/**
 * 
 * @desc 学生信息
 *
 * @author bjpowernode
 */
@Entity
@Table(name="T_B_STUDENT")
public class StudentEntity extends BaseEntity{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2280744824776533775L;

	/**
	 * 学号
	 */
	@Column(length = 15)
	private String studentnum;
	
	/**
	 * 姓名
	 */
	@Column(length = 10)
	private String name;
	
	/**
	 * 性别
	 */
	@Column(length = 1)
	private String sex;
	
	/**
	 * 出生日期
	 */
	@Column(length = 20)
	private Date birthday;
	
	/**
	 * qq
	 */
	@Column(length = 15)
	private String qq;
	
	/**
	 * 电话
	 */
	@Column(length = 15)
	private String mobile;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStudentnum() {
		return studentnum;
	}

	public void setStudentnum(String studentnum) {
		this.studentnum = studentnum;
	}
	
}