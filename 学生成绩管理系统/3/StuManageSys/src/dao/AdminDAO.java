package dao;

import java.util.List;

import models.Admin;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for Admin entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see models.Admin
  * @author MyEclipse Persistence Tools 
 */

public class AdminDAO extends HibernateDaoSupport implements IAdminDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AdminDAO.class);
		protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.IAdminDAO#save(models.Admin)
	 */
    public void save(Admin transientInstance) {
        log.debug("saving Admin instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.IAdminDAO#delete(models.Admin)
	 */
	public void delete(Admin persistentInstance) {
        log.debug("deleting Admin instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IAdminDAO#findById(java.lang.Integer)
	 */
    public Admin findById( java.lang.Integer id) {
        log.debug("getting Admin instance with id: " + id);
        try {
            Admin instance = (Admin) getHibernateTemplate()
                    .get("models.Admin", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.IAdminDAO#findByExample(models.Admin)
	 */
    public List findByExample(Admin instance) {
        log.debug("finding Admin instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    /* (non-Javadoc)
	 * @see dao.IAdminDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Admin instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Admin as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see dao.IAdminDAO#findByAdminId(java.lang.Object)
	 */
	public List findByAdminId(Object adminId
	) {
		return findByProperty(ADMIN_ID, adminId
		);
	}
	
	/* (non-Javadoc)
	 * @see dao.IAdminDAO#findByAdminName(java.lang.Object)
	 */
	public List findByAdminName(Object adminName
	) {
		return findByProperty(ADMIN_NAME, adminName
		);
	}
	
	/* (non-Javadoc)
	 * @see dao.IAdminDAO#findByAdminPs(java.lang.Object)
	 */
	public List findByAdminPs(Object adminPs
	) {
		return findByProperty(ADMIN_PS, adminPs
		);
	}
	

	/* (non-Javadoc)
	 * @see dao.IAdminDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Admin instances");
		try {
			String queryString = "from Admin";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.IAdminDAO#merge(models.Admin)
	 */
    public Admin merge(Admin detachedInstance) {
        log.debug("merging Admin instance");
        try {
            Admin result = (Admin) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.IAdminDAO#attachDirty(models.Admin)
	 */
    public void attachDirty(Admin instance) {
        log.debug("attaching dirty Admin instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IAdminDAO#attachClean(models.Admin)
	 */
    public void attachClean(Admin instance) {
        log.debug("attaching clean Admin instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IAdminDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IAdminDAO) ctx.getBean("AdminDAO");
	}
}