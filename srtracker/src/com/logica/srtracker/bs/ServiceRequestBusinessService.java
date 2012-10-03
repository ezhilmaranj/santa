package com.logica.srtracker.bs;

import com.logica.srtracker.dao.IServiceRequestDAO;
import com.logica.srtracker.request.ServiceRequestRequest;
import com.logica.srtracker.response.ServiceRequestResponse;

public class ServiceRequestBusinessService implements
		IServiceRequestBusinessService {

	private IServiceRequestDAO serviceRequestDAO;

	public void setServiceRequestDAO(IServiceRequestDAO serviceRequestDAO) {
		this.serviceRequestDAO = serviceRequestDAO;
	}
	
	@Override
	public ServiceRequestResponse cadReport(ServiceRequestRequest request) {
		
		ServiceRequestResponse response = serviceRequestDAO
				.cadReport(request);
		return response;
	}
	
	@Override
	public ServiceRequestResponse boltStatusReport(ServiceRequestRequest request) {
		ServiceRequestResponse response = serviceRequestDAO
				.boltStatusReport(request);
		return response;
	}

	@Override
	public ServiceRequestResponse reviewReport(ServiceRequestRequest request) {
		ServiceRequestResponse response = serviceRequestDAO
				.reviewReport(request);
		return response;
	}

	@Override
	public ServiceRequestResponse updateServiceRequest(
			ServiceRequestRequest request) {
		ServiceRequestResponse response = serviceRequestDAO
				.updateServiceRequest(request);
		return response;
	}

	@Override
	public ServiceRequestResponse uploadServiceRequest(
			ServiceRequestRequest request) {
		ServiceRequestResponse response = serviceRequestDAO
				.uploadServiceRequestList(request);
		return response;
	}

	@Override
	public ServiceRequestResponse getAllServiceRequest() {
		ServiceRequestResponse response = serviceRequestDAO
				.getAllServiceRequestList();
		if (response.getErrors() == null) {
			response.setStatus(true);
		} else {
			response.setStatusDescription(response.getErrors().getErrDesc());
		}
		return response;
	}

	@Override
	public ServiceRequestResponse getServiceRequest(
			ServiceRequestRequest request) {
		ServiceRequestResponse response = serviceRequestDAO
				.getServiceRequest(request);
		return response;
	}

}
