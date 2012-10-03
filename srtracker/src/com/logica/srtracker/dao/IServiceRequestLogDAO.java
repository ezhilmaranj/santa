package com.logica.srtracker.dao;

import java.util.List;

import com.logica.srtracker.data.ServiceRequestLog;

public interface IServiceRequestLogDAO {

	public abstract void save(ServiceRequestLog transientInstance);

	public abstract void delete(ServiceRequestLog persistentInstance);

	public abstract ServiceRequestLog findById(java.lang.Integer id);

	public abstract List findByExample(ServiceRequestLog instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByOldMessage(Object oldMessage);

	public abstract List findByNewMessage(Object newMessage);

	public abstract List findAll();

	public abstract ServiceRequestLog merge(ServiceRequestLog detachedInstance);

	public abstract void attachDirty(ServiceRequestLog instance);

	public abstract void attachClean(ServiceRequestLog instance);

}