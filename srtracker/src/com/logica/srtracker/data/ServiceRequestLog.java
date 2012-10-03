package com.logica.srtracker.data;

import java.util.Date;

/**
 * ServiceRequestLog entity. @author MyEclipse Persistence Tools
 */

public class ServiceRequestLog implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer serialNumber;
	private UserInfo userInfo;
	private ServiceRequest serviceRequest;
	private Date updatedOn;
	private String oldMessage;
	private String srStatus;
	private String newMessage;

	// Constructors

	/** default constructor */
	public ServiceRequestLog() {
	}

	/** minimal constructor */
	public ServiceRequestLog(UserInfo userInfo, Date updatedOn,
			String oldMessage, String newMessage) {
		this.userInfo = userInfo;
		this.updatedOn = updatedOn;
		this.oldMessage = oldMessage;
		this.newMessage = newMessage;
	}

	/** full constructor */
	public ServiceRequestLog(UserInfo userInfo, ServiceRequest serviceRequest,
			Date updatedOn, String oldMessage, String newMessage) {
		this.userInfo = userInfo;
		this.serviceRequest = serviceRequest;
		this.updatedOn = updatedOn;
		this.oldMessage = oldMessage;
		this.newMessage = newMessage;
	}

	// Property accessors

	public Integer getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public ServiceRequest getServiceRequest() {
		return this.serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getOldMessage() {
		return this.oldMessage;
	}

	public void setOldMessage(String oldMessage) {
		this.oldMessage = oldMessage;
	}

	public String getNewMessage() {
		return this.newMessage;
	}

	public void setNewMessage(String newMessage) {
		this.newMessage = newMessage;
	}

	public String getSrStatus() {
		return srStatus;
	}

	public void setSrStatus(String srStatus) {
		this.srStatus = srStatus;
	}
}