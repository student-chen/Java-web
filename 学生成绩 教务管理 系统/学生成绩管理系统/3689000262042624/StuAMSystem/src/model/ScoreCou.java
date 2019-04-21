package model;

import java.util.Date;

public class ScoreCou {
	
	private String courseName;
	private int courseCredit;  //学分
	private int courseHours;  //学时
	private String courseTeacher;
	private String major;
	private Date courseDate;
	private double scoreGrade;
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Date getCourseDate() {
		return courseDate;
	}
	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}
	public double getScoreGrade() {
		return scoreGrade;
	}
	public void setScoreGrade(double scoreGrade) {
		this.scoreGrade = scoreGrade;
	}
	public ScoreCou() {
		super();
		
	}
	
	public ScoreCou(String courseName, int courseCredit, int courseHours,
			String courseTeacher, String major, Date courseDate,
			double scoreGrade) {
		super();
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.courseHours = courseHours;
		this.courseTeacher = courseTeacher;
		this.major = major;
		this.courseDate = courseDate;
		this.scoreGrade = scoreGrade;
	}
	
	
}
