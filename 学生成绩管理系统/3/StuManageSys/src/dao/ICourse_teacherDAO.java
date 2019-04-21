package dao;

import java.util.List;

import models.Course_teacher;

public interface ICourse_teacherDAO {

	public abstract void save(Course_teacher transientInstance);

	public abstract void delete(Course_teacher persistentInstance);

	public abstract Course_teacher findById(java.lang.Integer id);

	public abstract List findByExample(Course_teacher instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findAll();

	public abstract Course_teacher merge(Course_teacher detachedInstance);

	public abstract void attachDirty(Course_teacher instance);

	public abstract void attachClean(Course_teacher instance);

}