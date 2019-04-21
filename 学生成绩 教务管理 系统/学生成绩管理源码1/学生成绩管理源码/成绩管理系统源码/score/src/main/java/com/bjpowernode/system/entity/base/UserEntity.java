package com.bjpowernode.system.entity.base;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bjpowernode.common.entity.base.BaseEntity;

/**
 * 
 * @desc 用户表
 *
 * @author bjpowernode
 */
@Entity
@Table(name="T_S_USER")
public class UserEntity extends BaseEntity{
	
	private static final long serialVersionUID = 6455189720167859325L;
	
	public static int STATUS_NORMAL = 1 ;
	public static int  STATUS_FORBIDDEN = 2;
	
	
	/**
	 * 用户名
	 */
	@Column(nullable = false,length=50)
	private String username;
	/**
	 * 密码
	 */
	@Column(nullable = false,length=32)
	private String password;
	
	/**
	 * 真实姓名
	 */
	@Column(name = "real_name",length=10)
	private String realName;
	/**
	 * 电子邮件
	 */
	@Column(length=50)
	private String email;
	/**
	 * 电话
	 */
	@Column(length=20)
	private String phone;
	/**
	 * 职务
	 */
	@Column(length=20)
	private String position;
	/**
	 * 职务说明
	 */
	@Column(name = "position_desc",length=100)
	private String positonDesc;


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_S_USER_ROLE", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private  List<RoleEntity> roles;
	
	

	/**
	 * 1 : 正常  2 :禁用
	 */
	private Integer status;

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPositonDesc() {
		return positonDesc;
	}

	public void setPositonDesc(String positonDesc) {
		this.positonDesc = positonDesc;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}