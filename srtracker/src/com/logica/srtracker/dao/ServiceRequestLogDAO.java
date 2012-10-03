package com.logica.srtracker.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.logica.srtracker.data.ServiceRequestLog;

/**
 * A data access object (DAO) providing persistence and search support for
 * ServiceRequestLog entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.logica.srtracker.data.ServiceRequestLog
 * @author MyEclipse Persistence Tools
 */

public class ServiceRequestLogDAO extends HibernateDaoSupport implements IServiceRequestLogDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ServiceRequestLogDAO.class);
	// property constants
	public static final String OLD_MESSAGE = "oldMessage";
	public static final String NEW_MESSAGE = "newMessage";

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(ServiceRequestLog transientInstance) {
		log.debug("saving ServiceRequestLog instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(ServiceRequestLog persistentInstance) {
		log.debug("deleting ServiceRequestLog instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public ServiceRequestLog findById(java.lang.Integer id) {
		log.debug("getting ServiceRequestLog instance with id: " + id);
		try {
			ServiceRequestLog instance = (ServiceRequestLog) getHibernateTemplate()
					.get("com.logica.srtracker.data.ServiceRequestLog", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findByExample(ServiceRequestLog instance) {
		log.debug("finding ServiceRequestLog instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding ServiceRequestLog instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ServiceRequestLog as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List findByOldMessage(Object oldMessage) {
		return findByProperty(OLD_MESSAGE, oldMessage);
	}

	@Override
	public List findByNewMessage(Object newMessage) {
		return findByProperty(NEW_MESSAGE, newMessage);
	}

	@Override
	public List findAll() {
		log.debug("finding all ServiceRequestLog instances");
		try {
			String queryString = "from ServiceRequestLog";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public ServiceRequestLog merge(ServiceRequestLog detachedInstance) {
		log.debug("merging ServiceRequestLog instance");
		try {
			ServiceRequestLog result = (ServiceRequestLog) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(ServiceRequestLog instance) {
		log.debug("attaching dirty ServiceRequestLog instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(ServiceRequestLog instance) {
		log.debug("attaching clean ServiceRequestLog instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IServiceRequestLogDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IServiceRequestLogDAO) ctx.getBean("ServiceRequestLogDAO");
	}
}