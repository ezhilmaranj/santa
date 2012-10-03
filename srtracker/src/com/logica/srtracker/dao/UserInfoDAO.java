package com.logica.srtracker.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.logica.srtracker.data.UserInfo;
import com.logica.srtracker.error.Errors;
import com.logica.srtracker.request.UserInfoRequest;
import com.logica.srtracker.response.Response;
import com.logica.srtracker.response.UserInfoResponse;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.logica.srtracker.data.UserInfo
 * @author MyEclipse Persistence Tools
 */

public class UserInfoDAO extends HibernateDaoSupport implements IUserInfoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserInfoDAO.class);
	// property constants
	public static final String PASSWORD = "password";
	public static final String EMAIL = "email";
	public static final String ROLE = "role";

	protected void initDao() {
		// do nothing
	}

	@Override
	public UserInfoResponse changePassword(UserInfoRequest request) {
		UserInfoResponse response = new UserInfoResponse();
		UserInfo userInfo = findById(request.getUserName());
		userInfo.setPassword(request.getPassword());
		try {
			attachDirty(userInfo);
			response.setStatus(true);
		} catch (Exception e) {
			response.setErrors(new Errors("SRT-106",
					"Failed to Change Password..."));
			response.setStatus(false);
			return response;

		}

		return response;
	}

	@Override
	public UserInfoResponse register(UserInfoRequest request) {
		UserInfoResponse response = new UserInfoResponse();

		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(request.getUserName());
		userInfo.setPassword(request.getPassword());
		userInfo.setEmail(request.getEmail());
		userInfo.setRole(request.getRole());
		try {
			save(userInfo);
			response.setStatus(true);
		} catch (Exception e) {
			response.setErrors(new Errors("SRT-106",
					"User Registration Fail..!"));
			response.setStatus(false);
			return response;
		}
		return response;
	}

	@Override
	public UserInfoResponse validate(UserInfoRequest request) {
		UserInfoResponse response = new UserInfoResponse();
		List<UserInfo> user = getHibernateTemplate().find(
				"FROM UserInfo WHERE userName='" + request.getUserName()
						+ "' and password='" + request.getPassword() + "'");
		if (user.size() > 0) {
			response.setStatus(true);
			response.setUserInfo(user.get(0));
		} else {
			response.setStatus(false);
			response.setErrors(new Errors("SRT-105", "Invalid User..!"));
		}
		return response;
	}

	@Override
	public void save(UserInfo transientInstance) {
		log.debug("saving UserInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(UserInfo persistentInstance) {
		log.debug("deleting UserInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public UserInfo findById(java.lang.String id) {
		log.debug("getting UserInfo instance with id: " + id);
		try {
			UserInfo instance = (UserInfo) getHibernateTemplate().get(
					"com.logica.srtracker.data.UserInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findByExample(UserInfo instance) {
		log.debug("finding UserInfo instance by example");
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
		log.debug("finding UserInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	@Override
	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	@Override
	public List findByRole(Object role) {
		return findByProperty(ROLE, role);
	}

	@Override
	public List findAll() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public UserInfo merge(UserInfo detachedInstance) {
		log.debug("merging UserInfo instance");
		try {
			UserInfo result = (UserInfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(UserInfo instance) {
		log.debug("attaching dirty UserInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(UserInfo instance) {
		log.debug("attaching clean UserInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IUserInfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IUserInfoDAO) ctx.getBean("UserInfoDAO");
	}
}