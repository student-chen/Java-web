package com.bjpowernode.system.entity.base;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.bjpowernode.common.entity.base.BaseEntity;

/**
 * 
 * @desc 角色表
 *
 * @author bjpowernode
 */
@Entity
@Table(name="T_S_ROLE")
public class RoleEntity extends BaseEntity{
	
	private static final long serialVersionUID = 87642784845062235L;
	/**
	 * 角色名
	 */
	@Column(nullable =false,length=50)
	private String name;
	/**
	 * 角色描述
	 */
	@Column(length=200)
	private String description;
	/**
	 * 拥有权限
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="T_S_ROLE_RESOURCE",joinColumns ={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="resource_id")})
	private List<ResourceEntity> resource;  
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ResourceEntity> getResource() {
		return resource;
	}

	public void setResource(List<ResourceEntity> resource) {
		this.resource = resource;
	}

	@Override
	public String toString() {
		return super.getId();
	}
	
	
	
}