package com.bjpowernode.system.entity.base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bjpowernode.common.entity.base.BaseEntity;

/**
 * 
 * @desc 部门表
 *
 * @author bjpowernode
 */
@Entity
@Table(name="T_S_DEPART")
public class DepartEntity extends BaseEntity{
	
	private static final long serialVersionUID = 3493122928615586987L;
	
	/**
	 * 部门名称
	 */
	@Column(length = 45)
	private String departname;
	
	/**
	 * 部门描述
	 */
	@Column(length = 100)
	private String description;
	
	/**
	 * 上级部门
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentid")
	private DepartEntity parentDepart;
	
	/**
	 * 下属部门;
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parentDepart")
	private List<DepartEntity> Departs = new ArrayList<DepartEntity>();

	public String getDepartname() {
		return departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public List<DepartEntity> getDeparts() {
		return Departs;
	}

	public void setDeparts(List<DepartEntity> departs) {
		Departs = departs;
	}

	public DepartEntity getParentDepart() {
		return parentDepart;
	}

	public void setParentDepart(DepartEntity parentDepart) {
		this.parentDepart = parentDepart;
	}

	
}