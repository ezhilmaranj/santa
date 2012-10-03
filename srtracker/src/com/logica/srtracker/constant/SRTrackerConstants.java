package com.logica.srtracker.constant;

public interface SRTrackerConstants {
	String FLAG_Y = "Y";
	String FLAG_N = "N";

	String DATE_FORMAT = "dd/MM/yyyy";
	String LOG_START = "=======================  START ==================================";
	String LOG_END = "=======================   END  ==================================";

	String COMMA_SEPARATOR = " ,";
	String ARROW_SEPARATOR = " ==> ";
	String OPEN_BRACKET = "[";
	String CLOSE_BRACKET = "] ";

	String DATABASE_EXCEPTION_MESSAGE = "failed while accessing database";
	String EXCEPTION_MESSAGE = "failed due exception";
	String STRING_RESPONSE = "response is ";
	String STRING_RESPONSE_BOOLEAN = "response(boolean) is ";
	String STRING_NO_RECORD = "No record found";
	
	String USER_LOGIN_FAILED_CODE = "300001";
	String USER_LOGIN_FAILED_MSG ="User Login Failed Due to Wrong Credential";

	// Properties file constants
	String PROPERTIES_SPRINGCONTEXT = "springApplicationContext.xml";

	String DualDAOImpl_CurrentDate = "SELECT SYSDATE() FROM DUAL";

	// Email constants
	String STATIC_SERVER_URL = "E:/images/";
	String INLINE_LOGICA_LOGOIMAGE_IDENTIFIER = "Logica Logo";
	String LOGICA_LOGOIMAGE = "Logica_logo_workspaces.png";
	String MESSAGE_ENCODING_TYPE = "UTF-8";
	String FROM_ADDRESS_PERSONALNAME = "Ezhilmaran Jayaraman";
	String SUPPORT_EMAIL_ADDRESS = "ezhilmaran.j@gmail.com";
	String REFER_YOUR_FRIEND_EMAIL_ADDRESS = "";
	String REGISTRATION_HTML_TEMPLATE_FILE = "com/logica/templates/html/customer_registration.vm";
	String REGISTRATION_TEXT_TEMPLATE_FILE = "com/logica/templates/text/customer_registration.vm";
	String ERROR_LOG_HTML_TEMPLATE_FILE = "com/logica/templates/html/error_mail.vm";
	String ERROR_LOG_TEXT_TEMPLATE_FILE = "com/logica/templates/text/error_mail.vm";
	String PASSWORD_LOG_HTML_TEMPLATE_FILE = "com/logica/templates/html/password_recover_mail.vm";
	String PASSWORD_LOG_TEXT_TEMPLATE_FILE = "com/logica/templates/text/password_recover_mail.vm";
	String REGISTRATION_SUBJECT = "Logica Registration";
	String PASSWORD_RECOVERY_SUBJECT = "Reset Your Password";
	String ERROR_SUBJECT = "Error Occured:";
}
