package com.logica.srtracker.bs;

import com.logica.srtracker.dao.IServiceRequestLogDAO;

public class ServiceRequestLogBusinessService implements
		IServiceRequestLogBusinessService {

	private IServiceRequestLogDAO serviceRequestLogDAO;

	public void setServiceRequestLogDAO(IServiceRequestLogDAO serviceRequestLogDAO) {
		this.serviceRequestLogDAO = serviceRequestLogDAO;
	}

	

	

}
