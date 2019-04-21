package dao;

import java.util.List;

import models.Admin;

public interface IAdminDAO {

	//property constants
	public static final String ADMIN_ID = "adminId";
	public static final String ADMIN_NAME = "adminName";
	public static final String ADMIN_PS = "adminPs";

	public abstract void save(Admin transientInstance);

	public abstract void delete(Admin persistentInstance);

	public abstract Admin findById(java.lang.Integer id);

	public abstract List findByExample(Admin instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByAdminId(Object adminId);

	public abstract List findByAdminName(Object adminName);

	public abstract List findByAdminPs(Object adminPs);

	public abstract List findAll();

	public abstract Admin merge(Admin detachedInstance);

	public abstract void attachDirty(Admin instance);

	public abstract void attachClean(Admin instance);

}