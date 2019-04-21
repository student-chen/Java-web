package dao;

import java.util.List;

import models.Student_course;

public interface IStudent_courseDAO {

	//property constants
	public static final String GRADE = "grade";

	public abstract void save(Student_course transientInstance);

	public abstract void delete(Student_course persistentInstance);

	public abstract Student_course findById(models.Student_courseId id);

	public abstract List findByExample(Student_course instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByGrade(Object grade);

	public abstract List findAll();

	public abstract Student_course merge(Student_course detachedInstance);

	public abstract void attachDirty(Student_course instance);

	public abstract void attachClean(Student_course instance);

}