package model;

public class Score {
	private int scoreID;
	private String stuNum;
	private String stuName;
	private String stuClass;
	private String courseName;
	private double scoreGrade;
	private String major;
	public int getScoreID() {
		return scoreID;
	}
	public void setScoreID(int scoreID) {
		this.scoreID = scoreID;
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
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getScoreGrade() {
		return scoreGrade;
	}
	public void setScoreGrade(double scoreGrade) {
		this.scoreGrade = scoreGrade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Score(int scoreID, String stuNum, String stuName, String stuClass,
			String courseName, double scoreGrade, String major) {
		super();
		this.scoreID = scoreID;
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.stuClass = stuClass;
		this.courseName = courseName;
		this.scoreGrade = scoreGrade;
		this.major = major;
	}
	public Score() {
		super();
	}
	public Score(String stuNum, String stuName, String stuClass,
			String courseName, double scoreGrade, String major) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.stuClass = stuClass;
		this.courseName = courseName;
		this.scoreGrade = scoreGrade;
		this.major = major;
	}
	
	
}
