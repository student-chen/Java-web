package entity;

import java.io.Serializable;

public class Cla2Sub implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Classes classes;
	private Subject subject;
	private Teacher teacher;// 主讲老师，新增

	public Cla2Sub() {
		this.classes = new Classes();
		this.subject = new Subject();
		this.teacher = new Teacher();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
