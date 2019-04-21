package entity;

import java.io.Serializable;

public class Operator implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String pwd;
	private Role role;

	public Operator()
	{
		this.role = new Role();
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

}
