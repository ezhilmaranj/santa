package com.logica.srtracker.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ServiceRequest entity. @author MyEclipse Persistence Tools
 */

public class ServiceRequest implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String srNumber;
	private UserInfo userInfo;
	private Date createdDate;
	private Date commitedDate;
	private String wrefrenceNumber;
	private String customerName;
	private String category;
	private String srStatus;
	private String srComments;
	private Date reviewDate;
	private Date updatedOn;
	private String boltStatus;
	private String requestType;
	private Set serviceRequestLogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public ServiceRequest() {
	}

	/** minimal constructor */
	public ServiceRequest(String srNumber, Date createdDate, Date commitedDate,
			String wrefrenceNumber, String customerName, String category,
			String srStatus, String srComments, Date updatedOn) {
		this.srNumber = srNumber;
		this.createdDate = createdDate;
		this.commitedDate = commitedDate;
		this.wrefrenceNumber = wrefrenceNumber;
		this.customerName = customerName;
		this.category = category;
		this.srStatus = srStatus;
		this.srComments = srComments;
		this.updatedOn = updatedOn;
	}

	/** full constructor */
	public ServiceRequest(String srNumber, UserInfo userInfo, Date createdDate,
			Date commitedDate, String wrefrenceNumber, String customerName,
			String category, String srStatus, String srComments,
			Date reviewDate, Date updatedOn, Set serviceRequestLogs) {
		this.srNumber = srNumber;
		this.userInfo = userInfo;
		this.createdDate = createdDate;
		this.commitedDate = commitedDate;
		this.wrefrenceNumber = wrefrenceNumber;
		this.customerName = customerName;
		this.category = category;
		this.srStatus = srStatus;
		this.srComments = srComments;
		this.reviewDate = reviewDate;
		this.updatedOn = updatedOn;
		this.serviceRequestLogs = serviceRequestLogs;
	}

	// Property accessors

	public String getSrNumber() {
		return this.srNumber;
	}

	public void setSrNumber(String srNumber) {
		this.srNumber = srNumber;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getCommitedDate() {
		return this.commitedDate;
	}

	public void setCommitedDate(Date commitedDate) {
		this.commitedDate = commitedDate;
	}

	public String getWrefrenceNumber() {
		return this.wrefrenceNumber;
	}

	public void setWrefrenceNumber(String wrefrenceNumber) {
		this.wrefrenceNumber = wrefrenceNumber;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSrStatus() {
		return this.srStatus;
	}

	public void setSrStatus(String srStatus) {
		this.srStatus = srStatus;
	}

	public String getSrComments() {
		return this.srComments;
	}

	public void setSrComments(String srComments) {
		this.srComments = srComments;
	}

	public Date getReviewDate() {
		return this.reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Set getServiceRequestLogs() {
		return this.serviceRequestLogs;
	}

	public void setServiceRequestLogs(Set serviceRequestLogs) {
		this.serviceRequestLogs = serviceRequestLogs;
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
	
	
}