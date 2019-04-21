package com.bjpowernode.buss.entity.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bjpowernode.common.entity.base.BaseEntity;

/**
 * 
 * @desc 教师
 *
 * @author bjpowernode
 */
@Entity
@Table(name="T_B_TEACHER")
public class TeacherEntity extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3752159363835368243L;

	/**
	 * 教师工号
	 */
	@Column(length = 20)
	private String teachernum;
	
	/**
	 * 教师姓名
	 */
	@Column(length = 10)
	private String teachername;
	
	/**
	 * 联系电话
	 */
	@Column(length = 20)
	private String phone;
	
	/**
	 * 职称
	 */
	@Column(length = 10)
	private String tittle;
	
	/**
	 * 入职时间
	 */
	@Column(length = 20)
	private Date starttime;
	

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTeachernum() {
		return teachernum;
	}

	public void setTeachernum(String teachernum) {
		this.teachernum = teachernum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}