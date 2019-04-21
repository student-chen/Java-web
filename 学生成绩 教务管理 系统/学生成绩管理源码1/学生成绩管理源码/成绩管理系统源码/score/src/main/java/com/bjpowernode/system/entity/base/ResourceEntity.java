package com.bjpowernode.system.entity.base;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.bjpowernode.common.entity.base.BaseEntity;

/**
 * 
 * @desc 资源表
 *
 * @author bjpowernode
 */
@Entity
@Table(name="T_S_RESOURCE")
@JsonIgnoreProperties("parent")
public class ResourceEntity extends BaseEntity{
	
	private static final long serialVersionUID = -2134869782502357553L;
	/** 资源类型-菜单级别 */
	public static int TYPE_MENU = 1;
	/** 资源类型-按钮级别*/
	public static int TYPE_BTN = 2;
	
	/**
	 * 资源类型
	 */
	private Integer resourceType;
	
	/**
	 * 权限名称
	 */
	@Column(length = 200)
	private String name;
	
	/**
	 * 权限描述
	 */
	@Column(length = 200)
	private String description;
	
	/**
	 * 排序
	 */
	@Column(length =  3 , name ="order_no")
	private Integer orderNo;
	
	/**
	 * 父节点
	 */
	@ManyToOne
	@JoinColumn(name = "parentid")
	private ResourceEntity parentResource;
	
	/**
	 * 子节点
	 */
	
	@OneToMany(mappedBy="parentResource",fetch=FetchType.EAGER)
	@OrderBy("orderNo")
	private List<ResourceEntity> resources;
	
	/**
	 * 链接
	 */
	@Column(length = 200)
	private String href;

	public Integer getResourceType() {
		return resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

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

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ResourceEntity getParentResource() {
		return parentResource;
	}

	public void setParentResource(ResourceEntity parentResource) {
		this.parentResource = parentResource;
	}

	public List<ResourceEntity> getResources() {
		return resources;
	}

	public void setResources(List<ResourceEntity> resources) {
		this.resources = resources;
	}
	
}

