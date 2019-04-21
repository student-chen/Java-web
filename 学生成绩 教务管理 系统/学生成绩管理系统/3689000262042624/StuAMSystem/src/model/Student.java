package model;

public class Student {
	private int stuID;
	private String stuNum;
	private String stuName;
	private String stuSex;
	private int stuAge;
	private String stuClass;
	private String major;
	private String department;  //Ժϵ
	public int getStuID() {
		return stuID;
	}
	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Student() {
		super();
	}
	
	public Student(String stuNum, String stuName, String stuSex, int stuAge,
			String stuClass, String major, String department) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuClass = stuClass;
		this.major = major;
		this.department = department;
	}
	public Student(int stuID, String stuNum, String stuName, String stuSex,
			int stuAge, String stuClass, String major, String department) {
		super();
		this.stuID = stuID;
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.stuClass = stuClass;
		this.major = major;
		this.department = department;
	}

	
}
