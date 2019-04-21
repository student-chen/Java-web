package entity;

import java.io.Serializable;

public class Major implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String prin;//专业负责人
	private String link;//专业联系人
	private String phone;//专业联系人电话
	
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

	public String getPrin() {
		return prin;
	}

	public void setPrin(String prin) {
		this.prin = prin;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
