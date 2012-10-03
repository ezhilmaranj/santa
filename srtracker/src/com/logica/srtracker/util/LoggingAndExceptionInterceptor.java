package com.logica.srtracker.util;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.dao.DataAccessException;
import com.logica.srtracker.constant.SRTrackerConstants;
import com.logica.srtracker.email.IEmailService;
import com.logica.srtracker.error.Errors;
import com.logica.srtracker.response.Response;
import com.logica.srtracker.to.EmailTO;

public class LoggingAndExceptionInterceptor implements MethodInterceptor {
	private static final Logger log = Logger
			.getLogger(LoggingAndExceptionInterceptor.class);
	private IEmailService emailService;

	public void setEmailService(IEmailService emailService) {
		this.emailService = emailService;
	}

	public Object invoke(MethodInvocation method) throws Throwable {
		StringBuilder requestMessage = new StringBuilder();
		long start = System.currentTimeMillis();
		log.debug("\n\n\t\t" + SRTrackerConstants.LOG_START);
		requestMessage.append(" Class Name : ").append(
				method.getMethod().getDeclaringClass() + "\n");
		requestMessage.append(" MethodName : ").append(
				method.getMethod().getName() + "\n");
		requestMessage.append(" Input(s)   : ");
		if (method.getArguments().length > 0) {
			for (int i = 0; i < method.getArguments().length; i++) {
				requestMessage.append(method.getArguments()[i] + "\t");
			}
		} else {
			requestMessage.append("No Input");
		}
		log.debug("Request from Frontend to BussinessService : \n"
				+ requestMessage);
		Response response = new Response();
		try {
			response = (Response) method.proceed();
		} catch (DataAccessException dae) {
			response.setErrors(new Errors(Errors.SYSTEM_ERROR_CODE_902,
					Errors.SYSTEM_ERROR_TEXT_902));
			response.setStatus(false);
			response.setStatusDescription(dae.getMessage());
			log.error("failed while accessing database " + dae.getMessage());

			EmailTO emailTO = new EmailTO();
			emailTO.fromId = SRTrackerConstants.SUPPORT_EMAIL_ADDRESS;
			emailTO.fromName = SRTrackerConstants.FROM_ADDRESS_PERSONALNAME;
			emailTO.toId = "clriiftllog@gmail.com";
			emailTO.fullName = "Ezhilmaran.J";
			emailTO.message = dae.getMessage();
			emailService.sendErrorEmail(emailTO);
		} catch (JDBCConnectionException je) {
			response.setErrors(new Errors(Errors.SYSTEM_ERROR_CODE_900,
					Errors.SYSTEM_ERROR_TEXT_900));
			response.setStatus(false);
			response.setStatusDescription(je.getMessage());
			log.error("failed due exception :-" + je.getMessage());

			EmailTO emailTO = new EmailTO();
			emailTO.fromId = SRTrackerConstants.SUPPORT_EMAIL_ADDRESS;
			emailTO.fromName = SRTrackerConstants.FROM_ADDRESS_PERSONALNAME;
			emailTO.toId = "clriiftllog@gmail.com";
			emailTO.fullName = "Ezhilmaran.J";
			emailTO.message = je.getMessage();
			emailService.sendErrorEmail(emailTO);
		} catch (Exception e) {
			response.setErrors(new Errors(Errors.SYSTEM_ERROR_CODE_900,
					Errors.SYSTEM_ERROR_TEXT_900));
			response.setStatus(false);
			response.setStatusDescription(e.getMessage());
			log.error(SRTrackerConstants.EXCEPTION_MESSAGE, e);

			EmailTO emailTO = new EmailTO();
			emailTO.fromId = SRTrackerConstants.SUPPORT_EMAIL_ADDRESS;
			emailTO.fromName = SRTrackerConstants.FROM_ADDRESS_PERSONALNAME;
			emailTO.toId = "clriiftllog@gmail.com";
			emailTO.fullName = "Ezhilmaran.J";
			emailTO.message = e.getMessage();
			emailService.sendErrorEmail(emailTO);
		}
		StringBuilder responseMessage = new StringBuilder();
		responseMessage.append(" Response   : ").append(
				response.toString() + "\n");
		responseMessage.append(" Time taken :");
		responseMessage.append(" [" + (System.currentTimeMillis() - start)
				+ "] milliseconds !");
		log.debug("Response to Frontend : \n" + responseMessage);

		log.info("\n\t\t" + SRTrackerConstants.LOG_END + "\n");
		return response;
	}
}