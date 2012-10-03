package com.logica.srtracker.email;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.logica.srtracker.constant.SRTrackerConstants;
import com.logica.srtracker.to.EmailTO;
import com.logica.srtracker.util.IAsyncService;
import com.logica.srtracker.util.LogicaUtils;

public class EmailServiceImpl implements IEmailService {
	private static final Logger log = Logger.getLogger(EmailServiceImpl.class);
	private VelocityEngine velocityEngine;
	private IAsyncService asyncService;
	private static FileSystemResource fileSystemResource;

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void setAsyncService(IAsyncService asyncService) {
		this.asyncService = asyncService;
	}

	static {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(SRTrackerConstants.STATIC_SERVER_URL);
		stringBuilder.append(SRTrackerConstants.LOGICA_LOGOIMAGE);
		fileSystemResource = new FileSystemResource(new File(
				stringBuilder.toString()));
	}

	@Override
	public void sendRegistrationEmail(final EmailTO emailTO) {
		MimeMessagePreparator mimepreparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage)
					throws javax.mail.MessagingException {
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
						mimeMessage, true,
						SRTrackerConstants.MESSAGE_ENCODING_TYPE);
				try {
					mimeMessageHelper.setFrom(emailTO.fromId, emailTO.fromName);
				} catch (UnsupportedEncodingException e) {
					log.error("Exception while setting From address in email",
							e);
				}
				mimeMessageHelper.setTo(emailTO.toId);
				mimeMessageHelper
						.setSubject(SRTrackerConstants.REGISTRATION_SUBJECT);
				Map<String, String> model = new HashMap<String, String>();
				model.put("name", emailTO.fullName);
				model.put("message", emailTO.message);
				String htmlMailContent = VelocityEngineUtils
						.mergeTemplateIntoString(
								velocityEngine,
								SRTrackerConstants.REGISTRATION_HTML_TEMPLATE_FILE,
								model);
				String textMailContent = VelocityEngineUtils
						.mergeTemplateIntoString(
								velocityEngine,
								SRTrackerConstants.REGISTRATION_TEXT_TEMPLATE_FILE,
								model);
				mimeMessageHelper.setText(textMailContent, htmlMailContent);
				// To embed image in email
				mimeMessageHelper.addInline(
						SRTrackerConstants.INLINE_LOGICA_LOGOIMAGE_IDENTIFIER,
						fileSystemResource);
			}
		};
		log.debug("Before sending");
		asyncService.sendEmailAsynchronoulsy(mimepreparator);
		log.debug("After sending");
		log.debug("Sending Registration Email");
	}

	@Override
	public void sendPasswordRecoveryEmail(final EmailTO emailTO) {
		MimeMessagePreparator mimepreparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage)
					throws javax.mail.MessagingException {
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
						mimeMessage, true,
						SRTrackerConstants.MESSAGE_ENCODING_TYPE);
				try {
					mimeMessageHelper.setFrom(emailTO.fromId, emailTO.fromName);
				} catch (UnsupportedEncodingException e) {
					log.error("Exception while setting From address in email",
							e);
				}
				mimeMessageHelper.setTo(emailTO.toId);
				mimeMessageHelper
						.setSubject(SRTrackerConstants.PASSWORD_RECOVERY_SUBJECT);
				Map<String, String> model = new HashMap<String, String>();
				model.put("name", emailTO.fullName);
				model.put("message", emailTO.message);
				String htmlMailContent = VelocityEngineUtils
						.mergeTemplateIntoString(
								velocityEngine,
								SRTrackerConstants.PASSWORD_LOG_HTML_TEMPLATE_FILE,
								model);
				String textMailContent = VelocityEngineUtils
						.mergeTemplateIntoString(
								velocityEngine,
								SRTrackerConstants.PASSWORD_LOG_TEXT_TEMPLATE_FILE,
								model);
				mimeMessageHelper.setText(textMailContent, htmlMailContent);
				// To embed image in email
				mimeMessageHelper.addInline(
						SRTrackerConstants.INLINE_LOGICA_LOGOIMAGE_IDENTIFIER,
						fileSystemResource);
			}
		};
		log.debug("Before sending");
		asyncService.sendEmailAsynchronoulsy(mimepreparator);
		log.debug("After sending");
		log.debug("Sending Registration Email");
	}

	public static void main(String[] args) {
		IEmailService emailService = (IEmailService) LogicaUtils
				.getSpringContext().getBean("emailService");
		EmailTO emailTO = new EmailTO();
		emailTO.fromId = SRTrackerConstants.SUPPORT_EMAIL_ADDRESS;
		emailTO.fromName = SRTrackerConstants.FROM_ADDRESS_PERSONALNAME;
		emailTO.toId = "ezhilmaran.j@gmail.com";
		emailTO.fullName = "Ezhilmaran.J";
		emailTO.message = "<a href=''>Click Here</a>";
		emailService.sendPasswordRecoveryEmail(emailTO);
	}

	@Override
	public void sendErrorEmail(final EmailTO emailTO) {
		MimeMessagePreparator mimepreparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage)
					throws javax.mail.MessagingException {
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
						mimeMessage, true,
						SRTrackerConstants.MESSAGE_ENCODING_TYPE);
				try {
					mimeMessageHelper.setFrom(emailTO.fromId, emailTO.fromName);
				} catch (UnsupportedEncodingException e) {
					log.error("Exception while setting From address in email",
							e);
				}
				mimeMessageHelper.setTo(emailTO.toId);
				mimeMessageHelper.setSubject(SRTrackerConstants.ERROR_SUBJECT);
				Map<String, String> model = new HashMap<String, String>();
				model.put("name", emailTO.fullName);
				model.put("message", emailTO.message);
				model.put("username", emailTO.user.getUserName());
				model.put("password", emailTO.user.getPassword());
				String htmlMailContent = VelocityEngineUtils
						.mergeTemplateIntoString(
								velocityEngine,
								SRTrackerConstants.REGISTRATION_HTML_TEMPLATE_FILE,
								model);
				String textMailContent = VelocityEngineUtils
						.mergeTemplateIntoString(
								velocityEngine,
								SRTrackerConstants.REGISTRATION_TEXT_TEMPLATE_FILE,
								model);
				mimeMessageHelper.setText(textMailContent, htmlMailContent);
				// To embed image in email
				mimeMessageHelper.addInline(
						SRTrackerConstants.INLINE_LOGICA_LOGOIMAGE_IDENTIFIER,
						fileSystemResource);
			}
		};
		log.debug("Before sending");
		asyncService.sendEmailAsynchronoulsy(mimepreparator);
		log.debug("After sending");
		log.debug("Sending Registration Email");
	}
}
