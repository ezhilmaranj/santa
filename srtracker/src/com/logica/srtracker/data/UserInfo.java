package com.logica.srtracker.data;

import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private String userName;
	private String password;
	private String email;
	private String role;
	private Set serviceRequests = new HashSet(0);
	private Set serviceRequestLogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(String userName, String password, String email, String role) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	/** full constructor */
	public UserInfo(String userName, String password, String email,
			String role, Set serviceRequests, Set serviceRequestLogs) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
		this.serviceRequests = serviceRequests;
		this.serviceRequestLogs = serviceRequestLogs;
	}

	// Property accessors

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set getServiceRequests() {
		return this.serviceRequests;
	}

	public void setServiceRequests(Set serviceRequests) {
		this.serviceRequests = serviceRequests;
	}

	public Set getServiceRequestLogs() {
		return this.serviceRequestLogs;
	}

	public void setServiceRequestLogs(Set serviceRequestLogs) {
		this.serviceRequestLogs = serviceRequestLogs;
	}

	
}