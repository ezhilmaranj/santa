package com.logica.srtracker.util;

import org.springframework.mail.javamail.MimeMessagePreparator;

public interface IAsyncService {
	void sendEmailAsynchronoulsy(MimeMessagePreparator mimepreparator);
}
