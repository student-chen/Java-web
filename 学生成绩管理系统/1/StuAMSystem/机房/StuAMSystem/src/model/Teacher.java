package model;

public class Teacher {
	private int teacID;
	private String teaNum;
	private String teaName;
	private String teaSex;
	private int teaAge;
	private String teaCourse;
	private String major;
	private String department;
	public int getTeacID() {
		return teacID;
	}
	public void setTeacID(int teacID) {
		this.teacID = teacID;
	}
	public String getTeaNum() {
		return teaNum;
	}
	public void setTeaNum(String teaNum) {
		this.teaNum = teaNum;
	}
	public String getTeaName() {
		return teaName;
	}
	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}
	public String getTeaSex() {
		return teaSex;
	}
	public void setTeaSex(String teaSex) {
		this.teaSex = teaSex;
	}
	public int getTeaAge() {
		return teaAge;
	}
	public void setTeaAge(int teaAge) {
		this.teaAge = teaAge;
	}
	public String getTeaCourse() {
		return teaCourse;
	}
	public void setTeaCourse(String teaCourse) {
		this.teaCourse = teaCourse;
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
	public Teacher(int teacID, String teaNum, String teaName, String teaSex,
			int teaAge, String teaCourse, String major, String department) {
		super();
		this.teacID = teacID;
		this.teaNum = teaNum;
		this.teaName = teaName;
		this.teaSex = teaSex;
		this.teaAge = teaAge;
		this.teaCourse = teaCourse;
		this.major = major;
		this.department = department;
	}
	public Teacher() {
		super();
	}
	public Teacher(String teaNum, String teaName, String teaSex, int teaAge,
			String teaCourse, String major, String department) {
		super();
		this.teaNum = teaNum;
		this.teaName = teaName;
		this.teaSex = teaSex;
		this.teaAge = teaAge;
		this.teaCourse = teaCourse;
		this.major = major;
		this.department = department;
	}
	
	
}
