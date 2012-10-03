package com.logica.srtracker.response;

import java.io.Serializable;

import com.logica.srtracker.error.Errors;

public class Response implements Serializable {
	private static final long serialVersionUID = 1056232922198210688L;
	private Errors error;
	private boolean status;
	private String statusDescription;

	public Response() {
		super();
	}

	public Response(Errors error, boolean status, String statusDescription) {
		super();
		this.error = error;
		this.status = status;
		this.statusDescription = statusDescription;
	}

	public Errors getErrors() {
		return error;
	}

	public void setErrors(Errors error) {
		this.error = error;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	@Override
	public String toString() {
		return "Response [error=" + error + ", status=" + status
				+ ", statusDescription=" + statusDescription + "]";
	}
}
