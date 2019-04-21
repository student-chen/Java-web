package dao;

import java.util.List;

import models.Student;

public interface IStudentDAO {

	//property constants
	public static final String STU_NAME = "stuName";
	public static final String STU_SEX = "stuSex";
	public static final String STU_ADDRESS = "stuAddress";
	public static final String STU_PHONE = "stuPhone";
	public static final String STU_SP = "stuSp";
	public static final String STU_CLASS = "stuClass";
	public static final String STU_EMAIL = "stuEmail";

	public abstract void save(Student transientInstance);

	public abstract void delete(Student persistentInstance);

	public abstract Student findById(java.lang.Integer id);

	public abstract List findByExample(Student instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByStuName(Object stuName);

	public abstract List findByStuSex(Object stuSex);

	public abstract List findByStuAddress(Object stuAddress);

	public abstract List findByStuPhone(Object stuPhone);

	public abstract List findByStuSp(Object stuSp);

	public abstract List findByStuClass(Object stuClass);

	public abstract List findByStuEmail(Object stuEmail);

	public abstract List findAll();

	public abstract Student merge(Student detachedInstance);

	public abstract void attachDirty(Student instance);

	public abstract void attachClean(Student instance);

}