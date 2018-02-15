package com.log4j2.lo4j2slack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2SlackApplication {

	private static final Logger LOGGER = LogManager.getLogger(Log4j2SlackApplication.class);

	public static void main(String[] args) {

		LOGGER.info("This is info message");
		LOGGER.error("This is error message");
		LOGGER.debug("This is debug message");
		
	}
}
