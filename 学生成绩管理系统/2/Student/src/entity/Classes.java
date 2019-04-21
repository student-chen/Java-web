package entity;

import java.io.Serializable;

public class Classes implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String tecName;//班主任姓名，新增
	private Major major;

	public Classes()
	{
		this.major = new Major();
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

	public Major getMajor()
	{
		return major;
	}

	public void setMajor(Major major)
	{
		this.major = major;
	}

	public String getTecName() {
		return tecName;
	}

	public void setTecName(String tec) {
		this.tecName = tec;
	}	
}
