package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Operator operator;
	private String no;
	private String name;
	private String sex;
	private Date birth;
	private String pic;
	private Classes classes;
	private SimpleDateFormat sdf;

	public Student()
	{
		this.operator = new Operator();
		this.classes = new Classes();
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

	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getBirth()
	{
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(birth);
	}

	public void setBirth(Date birth)
	{
		this.birth = birth;
	}

	public String getPic()
	{
		return pic;
	}

	public void setPic(String pic)
	{
		this.pic = pic;
	}

	public Classes getClasses()
	{
		return classes;
	}

	public void setClasses(Classes classes)
	{
		this.classes = classes;
	}

}
