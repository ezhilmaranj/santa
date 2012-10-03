package com.logica.srtracker.dao;

import java.util.List;

import com.logica.srtracker.data.ServiceRequest;
import com.logica.srtracker.request.ServiceRequestRequest;
import com.logica.srtracker.response.ServiceRequestResponse;

public interface IServiceRequestDAO {

	public abstract void save(ServiceRequest transientInstance);

	public abstract void delete(ServiceRequest persistentInstance);

	public abstract ServiceRequest findById(java.lang.String id);

	public abstract List findByExample(ServiceRequest instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByWrefrenceNumber(Object wrefrenceNumber);

	public abstract List findByCustomerName(Object customerName);

	public abstract List findByCategory(Object category);

	public abstract List findBySrStatus(Object srStatus);

	public abstract List findBySrComments(Object srComments);

	public abstract List findAll();

	public abstract ServiceRequest merge(ServiceRequest detachedInstance);

	public abstract void attachDirty(ServiceRequest instance);

	public abstract void attachClean(ServiceRequest instance);

	public abstract ServiceRequestResponse getAllServiceRequestList();

	public abstract ServiceRequestResponse uploadServiceRequestList(
			ServiceRequestRequest request);

	public abstract ServiceRequestResponse getServiceRequest(
			ServiceRequestRequest request);

	public abstract ServiceRequestResponse updateServiceRequest(
			ServiceRequestRequest request);

	public abstract ServiceRequestResponse reviewReport(
			ServiceRequestRequest request);

	public abstract ServiceRequestResponse boltStatusReport(
			ServiceRequestRequest request);
	
	public abstract ServiceRequestResponse cadReport(
			ServiceRequestRequest request);
}