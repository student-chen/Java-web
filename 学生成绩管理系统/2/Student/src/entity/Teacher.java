package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teacher implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Operator operator;
	private String name;
	private String sex;//性别，新增
	private Date birth;//出生日期，新增
	private String major;//专业，新增
	private String phone;//联系电话，新增
	public Teacher()
	{
		this.operator = new Operator();
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Operator getOperator()
	{
		return operator;
	}

	public void setOperator(Operator operator)
	{
		this.operator = operator;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(birth);
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
