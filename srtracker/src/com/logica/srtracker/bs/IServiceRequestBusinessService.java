package com.logica.srtracker.bs;

import com.logica.srtracker.request.ServiceRequestRequest;
import com.logica.srtracker.response.ServiceRequestResponse;

public interface IServiceRequestBusinessService {

	public abstract ServiceRequestResponse getAllServiceRequest();

	public abstract ServiceRequestResponse uploadServiceRequest(
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