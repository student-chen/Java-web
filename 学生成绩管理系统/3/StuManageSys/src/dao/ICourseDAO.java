package dao;

import java.util.List;

import models.Course;

public interface ICourseDAO {

	//property constants
	public static final String _CNAME = "CName";
	public static final String _CHOUR = "CHour";

	public abstract void save(Course transientInstance);

	public abstract void delete(Course persistentInstance);

	public abstract Course findById(java.lang.Integer id);

	public abstract List findByExample(Course instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCName(Object CName);

	public abstract List findByCHour(Object CHour);

	public abstract List findAll();

	public abstract Course merge(Course detachedInstance);

	public abstract void attachDirty(Course instance);

	public abstract void attachClean(Course instance);

}