package com.logica.srtracker.email;

import com.logica.srtracker.to.EmailTO;

public interface IEmailService {
	void sendRegistrationEmail(final EmailTO emailTO);

	void sendErrorEmail(final EmailTO emailTO);
	
	void sendPasswordRecoveryEmail(final EmailTO emailTO);
}
