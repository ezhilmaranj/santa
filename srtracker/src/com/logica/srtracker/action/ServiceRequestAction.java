package com.logica.srtracker.action;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.logica.srtracker.bs.IServiceRequestBusinessService;
import com.logica.srtracker.data.ServiceRequest;
import com.logica.srtracker.data.ServiceRequestLog;
import com.logica.srtracker.data.UserInfo;
import com.logica.srtracker.request.ServiceRequestRequest;
import com.logica.srtracker.response.ServiceRequestResponse;
import com.logica.srtracker.util.ExcelParser;
import com.logica.srtracker.util.LogicaUtils;
import com.opensymphony.xwork2.ActionSupport;

public class ServiceRequestAction extends ActionSupport implements SessionAware {

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

	IServiceRequestBusinessService serviceRequestBusinessService = (IServiceRequestBusinessService) LogicaUtils
			.getSpringContext().getBean("serviceRequestBusinessService");

	private Map<String, Object> session;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	private File srFile;

	public File getSrFile() {
		return srFile;
	}

	public void setSrFile(File srFile) {
		this.srFile = srFile;
	}

	public String upload() throws IOException {

		File sr = new File("E:\\SR Files\\SR.xls");
		FileUtils.copyFile(srFile, sr);

		ExcelParser ep = new ExcelParser();
		setServiceRequestList(ep.excelToList(sr));

		ServiceRequestRequest request = new ServiceRequestRequest();
		request.setServiceRequestsList(serviceRequestList);

		ServiceRequestResponse response = serviceRequestBusinessService
				.uploadServiceRequest(request);
		if (response.getStatus()) {
			addActionMessage("Data Upload Success..!");
		} else {
			addActionError(response.getErrors().getErrDesc());
		}

		return "uploadSuccess";
	}

	public String reviewReport() {
		ServiceRequestRequest request = new ServiceRequestRequest();
		request.setReviewDate(new Date(reviewDate));
		ServiceRequestResponse response = serviceRequestBusinessService
				.reviewReport(request);
		setServiceRequestList(response.getServiceRequestList());
		session.remove("serviceRequestList");
		session.put("serviceRequestList", response.getServiceRequestList());
		return "reviewReport";
	}
	
	public String boltStatusReport(){
		ServiceRequestRequest request = new ServiceRequestRequest();
		request.setBoltStatus(boltStatus);
		ServiceRequestResponse response = serviceRequestBusinessService
				.boltStatusReport(request);
		setServiceRequestList(response.getServiceRequestList());
		session.remove("serviceRequestList");
		session.put("serviceRequestList", response.getServiceRequestList());
		return "reviewReport";
	}
	
	public String cadReport(){
		ServiceRequestRequest request = new ServiceRequestRequest();
		request.setCommitedDate(new Date(commitedDate));
		ServiceRequestResponse response = serviceRequestBusinessService
				.cadReport(request);
		setServiceRequestList(response.getServiceRequestList());
		session.remove("serviceRequestList");
		session.put("serviceRequestList", response.getServiceRequestList());
		return "reviewReport";
	}

	public String exportToExcel() {
		setServiceRequestList((List) session.get("serviceRequestList"));
		return "excelReport";
	}

	public String list() {

		ServiceRequestResponse response = serviceRequestBusinessService
				.getAllServiceRequest();
		if (response.getStatus()) {
			serviceRequestList = response.getServiceRequestList();
		}
		if (serviceRequestList.size() < 0) {

		}
		session.remove("serviceRequestList");
		session.put("serviceRequestList", serviceRequestList);
		return "list";
	}

	public String view() throws IllegalAccessException,
			InvocationTargetException {
		ServiceRequestRequest request = new ServiceRequestRequest();
		ServiceRequest serviceRequest = new ServiceRequest();
		serviceRequest.setSrNumber(srNumber);
		request.setSrNumber(srNumber);
		ServiceRequestResponse response = serviceRequestBusinessService
				.getServiceRequest(request);
		BeanUtils.copyProperties(this, response.getServiceRequest());
		serviceRequest = response.getServiceRequest();
		setCreatedDate(formatDate(response.getServiceRequest().getCreatedDate()));
		setCommitedDate(formatDate(response.getServiceRequest()
				.getCommitedDate()));
		setReviewDate(formatDate(response.getServiceRequest().getReviewDate()));
		
		setServiceRequest(serviceRequest);
		return "serviceRequestView";
	}

	public String edit() throws IllegalAccessException,
			InvocationTargetException {
		ServiceRequestRequest request = new ServiceRequestRequest();
		ServiceRequest serviceRequest = new ServiceRequest();
		serviceRequest.setSrNumber(srNumber);
		request.setSrNumber(srNumber);
		ServiceRequestResponse response = serviceRequestBusinessService
				.getServiceRequest(request);
		BeanUtils.copyProperties(this, response.getServiceRequest());
		session.put("oldMessage", response.getServiceRequest().getSrComments());
		setCreatedDate(formatDate(response.getServiceRequest().getCreatedDate()));
		setCommitedDate(formatDate(response.getServiceRequest()
				.getCommitedDate()));
		setReviewDate(formatDate(response.getServiceRequest().getReviewDate()));
		return "serviceRequestEdit";
	}

	private String formatDate(Date date) {
		int y = date.getYear() + 1900;
		int m = date.getMonth() + 1;
		int day = date.getDate();
		return y + "/" + m + "/" + day;
	}

	public String update() throws IllegalAccessException,
			InvocationTargetException {

		ServiceRequestRequest request = new ServiceRequestRequest();
		ServiceRequest serviceRequest = new ServiceRequest();
		serviceRequest.setCreatedDate(new Date(createdDate));
		serviceRequest.setUpdatedOn(new Date(System.currentTimeMillis()));
		serviceRequest.setCommitedDate(new Date(commitedDate));
		serviceRequest.setReviewDate(new Date(reviewDate));
		serviceRequest.setWrefrenceNumber(wrefrenceNumber);
		serviceRequest.setSrNumber(srNumber);
		serviceRequest.setCategory(category);
		serviceRequest.setSrComments(srComments);
		serviceRequest.setCustomerName(customerName);
		serviceRequest.setSrStatus(srStatus);
		serviceRequest.setRequestType(requestType);
		serviceRequest.setBoltStatus(boltStatus);
		request.setOldMessage(session.get("oldMessage").toString());
		request.setServiceRequest(serviceRequest);
		request.setUserInfo((String)session.get("user"));

		ServiceRequestResponse response = serviceRequestBusinessService
				.updateServiceRequest(request);

		if (response.getStatus())
			return "serviceRequestUpdate";
		else {
			addActionError(response.getErrors().getErrDesc());
			return "serviceRequestEdit";
		}
	}

	private String srNumber;
	private String createdDate;
	private String commitedDate;
	private String wrefrenceNumber;
	private String customerName;
	private String category;
	private String srStatus;
	private String srComments;
	private String reviewDate;
	private String updatedOn;
	private ServiceRequest serviceRequest;
	private String oldMessage;
	private String oldSrStatus;
	private String boltStatus;
	private String requestType;

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	public String getSrNumber() {
		return srNumber;
	}

	public void setSrNumber(String srNumber) {
		this.srNumber = srNumber;
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCommitedDate() {
		return commitedDate;
	}

	public void setCommitedDate(String commitedDate) {
		this.commitedDate = commitedDate;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
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
