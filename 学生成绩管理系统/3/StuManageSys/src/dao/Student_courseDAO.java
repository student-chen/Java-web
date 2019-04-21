package dao;

import java.util.List;

import models.Student_course;
import models.Student_courseId;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for Student_course entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see models.Student_course
  * @author MyEclipse Persistence Tools 
 */

public class Student_courseDAO extends HibernateDaoSupport implements IStudent_courseDAO  {
	     private static final Logger log = LoggerFactory.getLogger(Student_courseDAO.class);
		protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.IStudent_courseDAO#save(models.Student_course)
	 */
    public void save(Student_course transientInstance) {
        log.debug("saving Student_course instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.IStudent_courseDAO#delete(models.Student_course)
	 */
	public void delete(Student_course persistentInstance) {
        log.debug("deleting Student_course instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IStudent_courseDAO#findById(models.Student_courseId)
	 */
    public Student_course findById( models.Student_courseId id) {
        log.debug("getting Student_course instance with id: " + id);
        try {
            Student_course instance = (Student_course) getHibernateTemplate()
                    .get("models.Student_course", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.IStudent_courseDAO#findByExample(models.Student_course)
	 */
    public List findByExample(Student_course instance) {
        log.debug("finding Student_course instance by example");
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
	 * @see dao.IStudent_courseDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Student_course instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Student_course as model where model." 
         						+ propertyName + "= ?";
         System.out.print(queryString);
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see dao.IStudent_courseDAO#findByGrade(java.lang.Object)
	 */
	public List findByGrade(Object grade
	) {
		return findByProperty(GRADE, grade
		);
	}
	

	/* (non-Javadoc)
	 * @see dao.IStudent_courseDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Student_course instances");
		try {
			String queryString = "from Student_course";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.IStudent_courseDAO#merge(models.Student_course)
	 */
    public Student_course merge(Student_course detachedInstance) {
        log.debug("merging Student_course instance");
        try {
            Student_course result = (Student_course) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.IStudent_courseDAO#attachDirty(models.Student_course)
	 */
    public void attachDirty(Student_course instance) {
        log.debug("attaching dirty Student_course instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IStudent_courseDAO#attachClean(models.Student_course)
	 */
    public void attachClean(Student_course instance) {
        log.debug("attaching clean Student_course instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IStudent_courseDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IStudent_courseDAO) ctx.getBean("Student_courseDAO");
	}
}