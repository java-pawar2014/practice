package org.springboot.springlogging;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SpringLoggingApplication {
	/**
	 * Apache Commons Logging
	 */
	// private static Log logger =
	// LogFactory.getLog(SpringLoggingApplication.class);

	/**
	 * Java Util Logging
	 */
	// private static Logger logger =
	// Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Log4j Logging
	 */
	private static Logger logger = Logger.getLogger(SpringLoggingApplication.class);

	/**
	 * Slf4j Logging
	 */
	// private static Logger logger =
	// LoggerFactory.getLogger(SpringLoggingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLoggingApplication.class, args);
		/**
		 * Apache Commons Logging
		 */
		// logger.info("Starting Spring Logging Application....");
		// logger.debug("Starting Spring Logging Application....");
		// logger.error("Starting Spring Logging Application....");
		// logger.fatal("Starting Spring Logging Application....");
		// logger.trace("Starting Spring Logging Application....");

		/**
		 * Java Util Logging
		 */
		// logger.info("Starting Spring Logging Application....");
		// logger.warning("Starting Spring Logging Application....");
		// logger.fine("Starting Spring Logging Application....");
		// logger.config("Starting Spring Logging Application....");
		// logger.finer("Starting Spring Logging Application....");
		// logger.finest("Starting Spring Logging Application....");

		/**
		 * Log4j Logging
		 */
		logger.info("Starting Spring Logging Application....");
		logger.debug("Starting Spring Logging Application....");
		logger.error("Starting Spring Logging Application....");
		logger.fatal("Starting Spring Logging Application....");
		logger.warn("Starting Spring Logging Application....");
		logger.trace("Starting Spring Logging Application....");
		logger.info("Starting Spring Logging Application....", new RuntimeException("Exception in logger"));

		/**
		 * Slf4j Logging
		 */
		// logger.info("Starting Spring Logging Application....");
		// logger.debug("Starting Spring Logging Application....");
		// logger.error("Starting Spring Logging Application....");
		// logger.warn("Starting Spring Logging Application....");
		// logger.trace("Starting Spring Logging Application....");

	}
}
