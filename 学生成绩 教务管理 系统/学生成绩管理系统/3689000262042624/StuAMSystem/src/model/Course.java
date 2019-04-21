package model;

import java.util.Date;

public class Course {
	private int courseID;
	private String courseName;
	private int courseCredit;  //学分
	private int courseHours;  //学时
	private String courseTeacher;
	private Date courseDate;
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}
	public int getCourseHours() {
		return courseHours;
	}
	public void setCourseHours(int courseHours) {
		this.courseHours = courseHours;
	}
	public String getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	public Date getCourseDate() {
		return courseDate;
	}
	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}
	public Course(int courseID, String courseName, int courseCredit,
			int courseHours, String courseTeacher, Date courseDate) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.courseHours = courseHours;
		this.courseTeacher = courseTeacher;
		this.courseDate = courseDate;
	}
	public Course() {
		super();
	}
	public Course(String courseName, int courseCredit, int courseHours,
			String courseTeacher, Date courseDate) {
		super();
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.courseHours = courseHours;
		this.courseTeacher = courseTeacher;
		this.courseDate = courseDate;
	}
	
	
}
