package cn.dinner.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * MenuType entity. @author MyEclipse Persistence Tools
 */

public class MenuType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typeName;
	private Set<Menu> menuList = new HashSet<Menu>();
	
	// Constructors

	/** default constructor */
	public MenuType() {
	}

	/** full constructor */
	public MenuType(String typeName) {
		this.typeName = typeName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(Set<Menu> menuList) {
		this.menuList = menuList;
	}
}