package entity;

import java.io.Serializable;

public class Subject implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String type;//课程类型，新增
	private  int times;//课时，新增

	public Integer getId()
	{
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
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
}
