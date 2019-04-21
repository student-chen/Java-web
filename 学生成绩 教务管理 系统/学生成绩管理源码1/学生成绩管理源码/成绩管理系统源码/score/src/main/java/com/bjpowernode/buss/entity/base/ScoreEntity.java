package com.bjpowernode.buss.entity.base;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bjpowernode.common.entity.base.BaseEntity;

/**
 * 
 * @desc 成绩
 *
 * @author bjpowernode
 */
@Entity
@Table(name="T_B_SCORE")
public class ScoreEntity extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1756666143133716363L;


	/**
	 * 分数
	 */
	@Column
	private BigDecimal score;
	
	
	/**
	 * 班级名称
	 */
	@Column(length = 20)
	private String classname;
	
	/**
	 * 学期
	 */
	@Column(length = 36)
	private String term;
	
	/**
	 * 课程名称
	 */
	@Column(length = 20)
	private String coursename;
	
	/**
	 * 教师
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "teacherid")
	private TeacherEntity teacherEntity;
	
	/**
	 * 学生
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "studentid")
	private StudentEntity studentEntity;

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public TeacherEntity getTeacherEntity() {
		return teacherEntity;
	}

	public void setTeacherEntity(TeacherEntity teacherEntity) {
		this.teacherEntity = teacherEntity;
	}

	public StudentEntity getStudentEntity() {
		return studentEntity;
	}

	public void setStudentEntity(StudentEntity studentEntity) {
		this.studentEntity = studentEntity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}