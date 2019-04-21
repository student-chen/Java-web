package com.jwy.dto;



public class Course implements java.io.Serializable {

	private Integer id;			
	private String name;		
	private String schooltime;	
	private String addr;		
	private Short credit;		
	private String courseInfo;	
	private String teacherName;	
	private String teacherInfo;	
	private Boolean isFinish;	
	private Integer specialtyId;

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(String name, String schooltime, String addr, Short credit,
			String courseInfo, String teacherName, String teacherInfo,
			Boolean isFinish, Integer specialtyId) {
		this.name = name;
		this.schooltime = schooltime;
		this.addr = addr;
		this.credit = credit;
		this.courseInfo = courseInfo;
		this.teacherName = teacherName;
		this.teacherInfo = teacherInfo;
		this.isFinish = isFinish;
		this.specialtyId = specialtyId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchooltime() {
		return this.schooltime;
	}

	public void setSchooltime(String schooltime) {
		this.schooltime = schooltime;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Short getCredit() {
		return this.credit;
	}

	public void setCredit(Short credit) {
		this.credit = credit;
	}

	public String getCourseInfo() {
		return this.courseInfo;
	}

	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherInfo() {
		return this.teacherInfo;
	}

	public void setTeacherInfo(String teacherInfo) {
		this.teacherInfo = teacherInfo;
	}

	public Boolean getIsFinish() {
		return this.isFinish;
	}

	public void setIsFinish(Boolean isFinish) {
		this.isFinish = isFinish;
	}

	public Integer getSpecialtyId() {
		return this.specialtyId;
	} 

	public void setSpecialtyId(Integer specialtyId) {
		this.specialtyId = specialtyId;
	}

}