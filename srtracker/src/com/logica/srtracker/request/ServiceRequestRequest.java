package com.logica.srtracker.request;

import java.util.Date;
import java.util.List;

import com.logica.srtracker.data.ServiceRequest;
import com.logica.srtracker.data.ServiceRequestLog;
import com.logica.srtracker.data.UserInfo;

public class ServiceRequestRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ServiceRequest> serviceRequestsList;
	private String srNumber;
	private Date createdDate;
	private Date commitedDate;
	private String wrefrenceNumber;
	private String customerName;
	private String category;
	private String srStatus;
	private String srComments;
	private Date reviewDate;
	private Date updatedOn;
	private ServiceRequest serviceRequest;
	private String oldMessage;
	private String oldSrStatus;
	private String boltStatus;
	private String requestType;
	private String userInfo;


	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getBoltStatus() {
		return boltStatus;
	}

	public void setBoltStatus(String boltStatus) {
		this.boltStatus = boltStatus;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	public List<ServiceRequest> getServiceRequestsList() {
		return serviceRequestsList;
	}

	public void setServiceRequestsList(List<ServiceRequest> serviceRequestsList) {
		this.serviceRequestsList = serviceRequestsList;
	}

	public String getSrNumber() {
		return srNumber;
	}

	public void setSrNumber(String srNumber) {
		this.srNumber = srNumber;
	}


	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getCommitedDate() {
		return commitedDate;
	}

	public void setCommitedDate(Date commitedDate) {
		this.commitedDate = commitedDate;
	}

	public String getWrefrenceNumber() {
		return wrefrenceNumber;
	}

	public void setWrefrenceNumber(String wrefrenceNumber) {
		this.wrefrenceNumber = wrefrenceNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSrStatus() {
		return srStatus;
	}

	public void setSrStatus(String srStatus) {
		this.srStatus = srStatus;
	}

	public String getSrComments() {
		return srComments;
	}

	public void setSrComments(String srComments) {
		this.srComments = srComments;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getOldMessage() {
		return oldMessage;
	}

	public void setOldMessage(String oldMessage) {
		this.oldMessage = oldMessage;
	}

	public String getOldSrStatus() {
		return oldSrStatus;
	}

	public void setOldSrStatus(String oldSrStatus) {
		this.oldSrStatus = oldSrStatus;
	}
}
