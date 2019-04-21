package entity;

import java.io.Serializable;

public class Score implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Double daily;
	private Double exam;
	private Double count;
	private Student student;
	private Subject subject;
	private Cla2Sub cla2sub;
	private Classes classes;

	public Score() {
		this.daily = new Double(0);
		this.exam = new Double(0);
		this.count = new Double(0);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getDaily() {
		return daily;
	}

	public void setDaily(Double daily) {
		this.daily = daily;
	}

	public Double getExam() {
		return exam;
	}

	public void setExam(Double exam) {
		this.exam = exam;
	}

	public Double getCount() {
		return count;
	}

	public void setCount(Double count) {
		this.count = count;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Cla2Sub getCla2sub() {
		return cla2sub;
	}

	public void setCla2sub(Cla2Sub cla2sub) {
		this.cla2sub = cla2sub;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

}
