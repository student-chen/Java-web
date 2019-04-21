package model;

public class ScoreSum {
	private int number;
	private String stuNum;
	private String stuName;
	private String stuClass;
	private String major;
	private double sumScore;
	private double avg;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public double getSumScore() {
		return sumScore;
	}
	public void setSumScore(double sumScore) {
		this.sumScore = sumScore;
	}
	
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public ScoreSum(int number,String stuNum, String stuName, String stuClass,
			String major, double sumScore,double avg) {
		super();
		this.number = number;
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.stuClass = stuClass;
		this.major = major;
		this.sumScore = sumScore;
		this.avg = avg;
	}
	public ScoreSum() {
		super();
	
	}
	
	

}
