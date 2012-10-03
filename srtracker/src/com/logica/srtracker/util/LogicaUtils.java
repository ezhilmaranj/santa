package com.logica.srtracker.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.logica.srtracker.constant.SRTrackerConstants;
import com.logica.srtracker.response.Response;

public final class LogicaUtils {
	private static final Logger log = Logger.getLogger(LogicaUtils.class);
	private static ClassPathXmlApplicationContext appContext = null;

	private LogicaUtils() {

	}

	public static ClassPathXmlApplicationContext getSpringContext() {
		if (appContext == null) {
			log.debug("Loading Spring applicationContext");
			appContext = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
			log.debug("Spring applicationContext Loaded !!!");
		}
		return appContext;
	}

	public static String getDisplayDateFormat(Date date) {
		if (date == null) {
			return null;
		}
		return DateFormat.getDateTimeInstance().format(date);
	}

	public static String getDateAlone(Date date) {
		if (date != null) {
			String response = "";
			try {
				String DATE_FORMAT = "dd-MM-yyyy";
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				response = sdf.format(date);
			} catch (Exception e) {
				log.error(e);
			}
			return response;
		} else {
			return "null(Empty)";
		}
	}

	public static void logRequest(Object request, Logger log, String methodName) {
		if (log.isDebugEnabled()) {
			log.debug("Request from Frontend to EJB Method : " + methodName);

			log.debug(SRTrackerConstants.LOG_START);

			log.debug("Request : " + request);

			log.debug(SRTrackerConstants.LOG_END);
		}
	}

	public static void logResponse(Response response, Logger log,
			String methodName, long startTime) {
		if (log.isDebugEnabled()) {
			log.debug("Response to Frontend from EJB Method : " + methodName);

			log.debug(SRTrackerConstants.LOG_START);

			log.debug("Response : " + response);

			log.debug("Response time ["
					+ (System.currentTimeMillis() - startTime)
					+ "] milliseconds!");

			log.debug(SRTrackerConstants.LOG_END);
		}
	}

	public static String collectionToString(Collection<?> collection) {
		StringBuilder stringBuilder = null;
		String retValue = null;
		if (collection != null && collection.size() > 0) {
			stringBuilder = new StringBuilder();
			stringBuilder.append(Arrays.toString(collection.toArray()));
			retValue = stringBuilder.toString();
		}
		return retValue;
	}

	public static String mapToString(Map<?, ?> map) {
		StringBuilder stringBuilder = null;
		String retValue = null;
		if (map != null && map.size() > 0) {
			stringBuilder = new StringBuilder("{");
			String SPACE_SEPARATOR = " ";
			for (Object object : map.keySet()) {
				if (object != null) {
					stringBuilder.append(SPACE_SEPARATOR)
							.append(object.toString())
							.append(SRTrackerConstants.ARROW_SEPARATOR)
							.append(SRTrackerConstants.OPEN_BRACKET);
					if (map.get(object) != null) {
						stringBuilder.append(map.get(object).toString())
								.append(SRTrackerConstants.CLOSE_BRACKET);
					} else {
						stringBuilder.append(map.get(object)).append(
								SRTrackerConstants.CLOSE_BRACKET);
					}
				} else {
					stringBuilder.append(SPACE_SEPARATOR).append(object)
							.append(SRTrackerConstants.ARROW_SEPARATOR)
							.append(SRTrackerConstants.OPEN_BRACKET);
					if (map.get(object) != null) {
						stringBuilder.append(map.get(object).toString())
								.append(SRTrackerConstants.CLOSE_BRACKET);
					} else {
						stringBuilder.append(map.get(object)).append(
								SRTrackerConstants.CLOSE_BRACKET);
					}
				}
				SPACE_SEPARATOR = SRTrackerConstants.COMMA_SEPARATOR;
			}
			retValue = stringBuilder.append("}").toString();
		}
		return retValue;
	}

	public static boolean validateRequestForNull(Object requestObj) {
		if (requestObj == null) {
			return true;
		}
		return false;
	}

	public static Date convertDate(String date) {
		Date respone = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				SRTrackerConstants.DATE_FORMAT);
		try {
			respone = simpleDateFormat.parse(date);
		} catch (ParseException e) {

			log.debug("Parse Exception");
			String DATE_FORMAT = "dd-MM-yyyy";
			simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
			try {
				respone = simpleDateFormat.parse(date);
			} catch (ParseException e1) {
				log.error("Error is: ", e);
			}
		}
		return respone;
	}

	public static Timestamp convertTimeStamp(String date) {
		Timestamp timestamp = null;
		Date respone = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				SRTrackerConstants.DATE_FORMAT);
		try {
			respone = simpleDateFormat.parse(date);
			timestamp = new Timestamp(respone.getTime());
		} catch (ParseException e) {
			log.debug("Parse Exception");
			String DATE_FORMAT = "dd-MM-yyyy";
			simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
			try {
				respone = simpleDateFormat.parse(date);
				timestamp = new Timestamp(respone.getTime());
			} catch (ParseException e1) {
				log.error("Error is: ", e);
			}
		}
		return timestamp;
	}
}
