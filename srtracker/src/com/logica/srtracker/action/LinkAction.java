package com.logica.srtracker.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class LinkAction implements SessionAware {

	private Map<String, Object> session;
	private String reportType;
	private String mandateField;

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getMandateField() {
		return mandateField;
	}

	public void setMandateField(String mandateField) {
		this.mandateField = mandateField;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String home() {
		return "home";
	}

	public String register() {
		return "register";
	}

	public String serviceRequest() {
		return "serviceRequest";
	}

	public String upload() {
		return "upload";
	}

	public String chooseReport() {
		return "chooseReport";
	}

	public String reviewReport() {
		return "reviewReport";
	}

	public String boltStatusReport() {
		return "boltStatusReport";
	}

	public String cadReport() {
		return "cadReport";
	}
	
	public String changePassword() {
		return "changePassword";
	}

}
