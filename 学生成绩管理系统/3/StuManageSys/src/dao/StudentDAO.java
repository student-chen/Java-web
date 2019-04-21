package dao;

import java.util.List;
import java.util.Set;

import models.Student;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 	* A data access object (DAO) providing persistence and search support for Student entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see models.Student
  * @author MyEclipse Persistence Tools 
 */

public class StudentDAO extends HibernateDaoSupport implements IStudentDAO  {
	     private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);
		protected void initDao() {
		//do nothing
	}
    
    /* (non-Javadoc)
	 * @see dao.IStudentDAO#save(models.Student)
	 */
    public void save(Student transientInstance) {
        log.debug("saving Student instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	/* (non-Javadoc)
	 * @see dao.IStudentDAO#delete(models.Student)
	 */
	public void delete(Student persistentInstance) {
        log.debug("deleting Student instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IStudentDAO#findById(java.lang.Integer)
	 */
    public Student findById( java.lang.Integer id) {
        log.debug("getting Student instance with id: " + id);
        try {
            Student instance = (Student) getHibernateTemplate()
                    .get("models.Student", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    /* (non-Javadoc)
	 * @see dao.IStudentDAO#findByExample(models.Student)
	 */
    public List findByExample(Student instance) {
        log.debug("finding Student instance by example");
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
	 * @see dao.IStudentDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Student instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Student as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	/* (non-Javadoc)
	 * @see dao.IStudentDAO#findByStuName(java.lang.Object)
	 */
	public List findByStuName(Object stuName
	) {
		return findByProperty(STU_NAME, stuName
		);
	}
	
	/* (non-Javadoc)
	 * @see dao.IStudentDAO#findByStuSex(java.lang.Object)
	 */
	public List findByStuSex(Object stuSex
	) {
		return findByProperty(STU_SEX, stuSex
		);
	}
	
	/* (non-Javadoc)
	 * @see dao.IStudentDAO#findByStuAddress(java.lang.Object)
	 */
	public List findByStuAddress(Object stuAddress
	) {
		return findByProperty(STU_ADDRESS, stuAddress
		);
	}
	
	/* (non-Javadoc)
	 * @see dao.IStudentDAO#findByStuPhone(java.lang.Object)
	 */
	public List findByStuPhone(Object stuPhone
	) {
		return findByProperty(STU_PHONE, stuPhone
		);
	}
	
	/* (non-Javadoc)
	 * @see dao.IStudentDAO#findByStuSp(java.lang.Object)
	 */
	public List findByStuSp(Object stuSp
	) {
		return findByProperty(STU_SP, stuSp
		);
	}
	
	/* (non-Javadoc)
	 * @see dao.IStudentDAO#findByStuClass(java.lang.Object)
	 */
	public List findByStuClass(Object stuClass
	) {
		return findByProperty(STU_CLASS, stuClass
		);
	}
	
	/* (non-Javadoc)
	 * @see dao.IStudentDAO#findByStuEmail(java.lang.Object)
	 */
	public List findByStuEmail(Object stuEmail
	) {
		return findByProperty(STU_EMAIL, stuEmail
		);
	}
	

	/* (non-Javadoc)
	 * @see dao.IStudentDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Student instances");
		try {
			String queryString = "from Student";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    /* (non-Javadoc)
	 * @see dao.IStudentDAO#merge(models.Student)
	 */
    public Student merge(Student detachedInstance) {
        log.debug("merging Student instance");
        try {
            Student result = (Student) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    /* (non-Javadoc)
	 * @see dao.IStudentDAO#attachDirty(models.Student)
	 */
    public void attachDirty(Student instance) {
        log.debug("attaching dirty Student instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    /* (non-Javadoc)
	 * @see dao.IStudentDAO#attachClean(models.Student)
	 */
    public void attachClean(Student instance) {
        log.debug("attaching clean Student instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static IStudentDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (IStudentDAO) ctx.getBean("StudentDAO");
	}
}