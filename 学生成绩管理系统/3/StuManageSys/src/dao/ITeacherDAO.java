package dao;

import java.util.List;

import models.Teacher;

public interface ITeacherDAO {

	//property constants
	public static final String _TNAME = "TName";
	public static final String _TPHONE = "TPhone";

	public abstract void save(Teacher transientInstance);

	public abstract void delete(Teacher persistentInstance);

	public abstract Teacher findById(java.lang.Integer id);

	public abstract List findByExample(Teacher instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTName(Object TName);

	public abstract List findByTPhone(Object TPhone);

	public abstract List findAll();

	public abstract Teacher merge(Teacher detachedInstance);

	public abstract void attachDirty(Teacher instance);

	public abstract void attachClean(Teacher instance);

}