package com.logica.srtracker.util;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;

public class AsyncServiceImpl implements IAsyncService {
	private static final Logger log = Logger.getLogger(AsyncServiceImpl.class);
	private JavaMailSender javaMailSender;

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	@Async
	public void sendEmailAsynchronoulsy(MimeMessagePreparator mimepreparator) {
		log.debug("start sendEmailAsynchronoulsy");
		javaMailSender.send(mimepreparator);
		log.debug("complete sendEmailAsynchronoulsy");
	}
}
