package com.logica.srtracker.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.logica.srtracker.data.ServiceRequest;
import com.logica.srtracker.data.ServiceRequestLog;
import com.logica.srtracker.data.UserInfo;
import com.logica.srtracker.error.Errors;
import com.logica.srtracker.request.ServiceRequestRequest;
import com.logica.srtracker.response.ServiceRequestResponse;
import com.logica.srtracker.util.LogicaUtils;

/**
 * A data access object (DAO) providing persistence and search support for
 * ServiceRequest entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.logica.srtracker.data.ServiceRequest
 * @author MyEclipse Persistence Tools
 */

public class ServiceRequestDAO extends HibernateDaoSupport implements
		IServiceRequestDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ServiceRequestDAO.class);
	// property constants
	public static final String WREFRENCE_NUMBER = "wrefrenceNumber";
	public static final String CUSTOMER_NAME = "customerName";
	public static final String CATEGORY = "category";
	public static final String SR_STATUS = "srStatus";
	public static final String SR_COMMENTS = "srComments";

	protected void initDao() {
		// do nothing
	}

	@Override
	public ServiceRequestResponse reviewReport(ServiceRequestRequest request) {
		ServiceRequestResponse response = new ServiceRequestResponse();
		List<ServiceRequest> serviceRequestList = null;
		try {
			serviceRequestList = getHibernateTemplate()
					.find("FROM ServiceRequest WHERE reviewDate <= '"
							+ request.getReviewDate() + "' AND srStatus='OPEN'");
		} catch (Exception e) {
			response.setErrors(new Errors("SRT-101",
					"Failed While Retriving Data..!"));
			response.setStatus(false);
			return response;
		}
		response.setServiceRequestList(serviceRequestList);
		return response;
	}

	@Override
	public ServiceRequestResponse boltStatusReport(ServiceRequestRequest request) {
		ServiceRequestResponse response = new ServiceRequestResponse();
		List<ServiceRequest> serviceRequestList = null;
		try {
			serviceRequestList = getHibernateTemplate()
					.find("FROM ServiceRequest WHERE boltStatus = '"
							+ request.getBoltStatus() + "' AND srStatus='OPEN'");
		} catch (Exception e) {
			response.setErrors(new Errors("SRT-101",
					"Failed While Retriving Data..!"));
			response.setStatus(false);
			return response;
		}
		response.setServiceRequestList(serviceRequestList);
		return response;
	}

	@Override
	public ServiceRequestResponse cadReport(ServiceRequestRequest request) {
		ServiceRequestResponse response = new ServiceRequestResponse();
		List<ServiceRequest> serviceRequestList = null;
		try {
			serviceRequestList = getHibernateTemplate().find(
					"FROM ServiceRequest WHERE commitedDate <= '"
							+ request.getCommitedDate()
							+ "' AND srStatus='OPEN'");
		} catch (Exception e) {
			response.setErrors(new Errors("SRT-101",
					"Failed While Retriving Data..!"));
			response.setStatus(false);
			return response;
		}
		response.setServiceRequestList(serviceRequestList);
		return response;
	}

	@Override
	public ServiceRequestResponse updateServiceRequest(
			ServiceRequestRequest request) {
		ServiceRequestResponse response = new ServiceRequestResponse();
		ServiceRequest serviceRequest = request.getServiceRequest();
		ServiceRequestLog serviceRequestLog = new ServiceRequestLog();

		IUserInfoDAO userInfoDAO = (IUserInfoDAO) LogicaUtils
				.getSpringContext().getBean("userInfoDAO");
		UserInfo user = userInfoDAO.findById(request.getUserInfo());

		serviceRequestLog.setServiceRequest(serviceRequest);
		serviceRequestLog.setOldMessage(request.getOldMessage());
		serviceRequestLog.setNewMessage(request.getServiceRequest()
				.getSrComments());
		serviceRequestLog.setUpdatedOn(request.getServiceRequest()
				.getUpdatedOn());
		serviceRequestLog.setSrStatus(serviceRequest.getSrStatus());
		serviceRequestLog.setUserInfo(user);
		Set<ServiceRequestLog> log = new TreeSet<ServiceRequestLog>();
		log.add(serviceRequestLog);
		serviceRequest.setServiceRequestLogs(log);
		serviceRequest.setUserInfo(user);

		try {
			attachDirty(serviceRequest);
			response.setStatus(true);
		} catch (Exception e) {
			response.setErrors(new Errors("SRT-ERROR-104",
					"Failed Updating ServiceRequest..!"));
			response.setStatus(false);
		}

		return response;
	}

	@Override
	public ServiceRequestResponse uploadServiceRequestList(
			ServiceRequestRequest request) {
		ServiceRequestResponse response = new ServiceRequestResponse();
		Iterator<ServiceRequest> it = request.getServiceRequestsList()
				.iterator();
		int i = 0;
		IUserInfoDAO userInfoDAO = (IUserInfoDAO) LogicaUtils
				.getSpringContext().getBean("userInfoDAO");
		UserInfo user = userInfoDAO.findById("Ezhilmaran");
		ServiceRequest sr = null;
		int duplicateCount = 0;
		while (it.hasNext()) {
			try {
				sr = it.next();
				sr.setUserInfo(user);
				ServiceRequest s = findById(sr.getSrNumber());
				if (s == null) {
					save(sr);
				} else {
					duplicateCount++;
				}
				i++;
			} catch (DataIntegrityViolationException duplicate) {
				response.setErrors(new Errors(
						"SRT-ERROR-103",
						"Service Request : "
								+ sr.getSrNumber()
								+ " Already Exist, Please Remove and Try Again..!"));
				duplicateCount++;
				i++;
			}
		}

		if (i == request.getServiceRequestsList().size()) {
			response.setStatus(true);
			response.setDuplicateCount(duplicateCount);
			response.setSrCount(i);
			System.out.println("Effectively Uploaded SR : "
					+ (i - duplicateCount));
		}

		return response;
	}

	@Override
	public ServiceRequestResponse getAllServiceRequestList() {
		ServiceRequestResponse response = new ServiceRequestResponse();
		try {
			List<ServiceRequest> serviceRequestList = getHibernateTemplate()
					.find("FROM ServiceRequest WHERE srStatus='OPEN'");
			response.setServiceRequestList(serviceRequestList);
		} catch (Exception e) {
			response.setErrors(new Errors("SRT-101",
					"Failed While Retriving Data..!"));
		}
		return response;
	}

	@Override
	public ServiceRequestResponse getServiceRequest(
			ServiceRequestRequest request) {
		ServiceRequestResponse response = new ServiceRequestResponse();
		ServiceRequest serviceRequest = findById(request.getSrNumber());
		response.setServiceRequest(serviceRequest);
		return response;
	}

	@Override
	public void save(ServiceRequest transientInstance) {
		log.debug("saving ServiceRequest instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(ServiceRequest persistentInstance) {
		log.debug("deleting ServiceRequest instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public ServiceRequest findById(java.lang.String id) {
		log.debug("getting ServiceRequest instance with id: " + id);
		try {
			ServiceRequest instance = (ServiceRequest) getHibernateTemplate()
					.get("com.logica.srtracker.data.ServiceRequest", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findByExample(ServiceRequest instance) {
		log.debug("finding ServiceRequest instance by example");
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
		log.debug("finding ServiceRequest instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ServiceRequest as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List findByWrefrenceNumber(Object wrefrenceNumber) {
		return findByProperty(WREFRENCE_NUMBER, wrefrenceNumber);
	}

	@Override
	public List findByCustomerName(Object customerName) {
		return findByProperty(CUSTOMER_NAME, customerName);
	}

	@Override
	public List findByCategory(Object category) {
		return findByProperty(CATEGORY, category);
	}

	@Override
	public List findBySrStatus(Object srStatus) {
		return findByProperty(SR_STATUS, srStatus);
	}

	@Override
	public List findBySrComments(Object srComments) {
		return findByProperty(SR_COMMENTS, srComments);
	}

	@Override
	public List findAll() {
		log.debug("finding all ServiceRequest instances");
		try {
			String queryString = "from ServiceRequest";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public ServiceRequest merge(ServiceRequest detachedInstance) {
		log.debug("merging ServiceRequest instance");
		try {
			ServiceRequest result = (ServiceRequest) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(ServiceRequest instance) {
		log.debug("attaching dirty ServiceRequest instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(ServiceRequest instance) {
		log.debug("attaching clean ServiceRequest instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IServiceRequestDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IServiceRequestDAO) ctx.getBean("ServiceRequestDAO");
	}
}