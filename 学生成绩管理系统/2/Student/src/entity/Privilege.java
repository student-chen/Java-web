package entity;

import java.io.Serializable;

public class Privilege implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String url;
	private String menu_name;
	private Role role;

	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menuName) {
		menu_name = menuName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
