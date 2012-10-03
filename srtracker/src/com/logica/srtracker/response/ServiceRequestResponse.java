package com.logica.srtracker.response;

import java.util.List;

import com.logica.srtracker.data.ServiceRequest;

public class ServiceRequestResponse extends Response {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ServiceRequest> serviceRequestList;
	
	public List<ServiceRequest> getServiceRequestList() {
		return serviceRequestList;
	}
	public void setServiceRequestList(List<ServiceRequest> serviceRequestList) {
		this.serviceRequestList = serviceRequestList;
	}
	
	private ServiceRequest serviceRequest;

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}
	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}
	
	private int srCount;
	private int duplicateCount;

	
	public int getDuplicateCount() {
		return duplicateCount;
	}

	public void setDuplicateCount(int duplicateCount) {
		this.duplicateCount = duplicateCount;
	}

	public int getSrCount() {
		return srCount;
	}

	public void setSrCount(int srCount) {
		this.srCount = srCount;
	}
	@Override
	public String toString() {
		return "ServiceRequestResponse [serviceRequestList="
				+ serviceRequestList + ", serviceRequest=" + serviceRequest
				+ ", srCount=" + srCount + ", duplicateCount=" + duplicateCount
				+ "]";
	}
	
	

}
