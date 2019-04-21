package dao;

import java.util.List;
import java.util.Set;

import models.Course_teacher;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for Course_teacher entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see models.Course_teacher
  * @author MyEclipse Persistence Tools 
 */

public class Course_teacherDAO extends HibernateDaoSupport implements ICourse_teacherDAO  {
	     private static final Logger log = LoggerFactory.getLogger(Course_teacherDAO.class);
		//property constants



	protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.ICourse_teacherDAO#save(models.Course_teacher)
	 */
    public void save(Course_teacher transientInstance) {
        log.debug("saving Course_teacher instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.ICourse_teacherDAO#delete(models.Course_teacher)
	 */
	public void delete(Course_teacher persistentInstance) {
        log.debug("deleting Course_teacher instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.ICourse_teacherDAO#findById(java.lang.Integer)
	 */
    public Course_teacher findById( java.lang.Integer id) {
        log.debug("getting Course_teacher instance with id: " + id);
        try {
            Course_teacher instance = (Course_teacher) getHibernateTemplate()
                    .get("models.Course_teacher", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.ICourse_teacherDAO#findByExample(models.Course_teacher)
	 */
    public List findByExample(Course_teacher instance) {
        log.debug("finding Course_teacher instance by example");
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
	 * @see dao.ICourse_teacherDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Course_teacher instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Course_teacher as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	/* (non-Javadoc)
	 * @see dao.ICourse_teacherDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Course_teacher instances");
		try {
			String queryString = "from Course_teacher";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.ICourse_teacherDAO#merge(models.Course_teacher)
	 */
    public Course_teacher merge(Course_teacher detachedInstance) {
        log.debug("merging Course_teacher instance");
        try {
            Course_teacher result = (Course_teacher) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.ICourse_teacherDAO#attachDirty(models.Course_teacher)
	 */
    public void attachDirty(Course_teacher instance) {
        log.debug("attaching dirty Course_teacher instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.ICourse_teacherDAO#attachClean(models.Course_teacher)
	 */
    public void attachClean(Course_teacher instance) {
        log.debug("attaching clean Course_teacher instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ICourse_teacherDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ICourse_teacherDAO) ctx.getBean("Course_teacherDAO");
	}
}