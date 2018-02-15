package com.log4j.log4j2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;

public class Log4j2Application {
	private static final Marker SLACK = MarkerManager.getMarker("SLACK");
	private static Logger logger = LogManager.getLogger(Log4j2Application.class);
	private static final String LOG_FILE = "logs/log4j2.log";
	public static final String NEWLINE = System.getProperty("line.separator");

	public static void main(String[] args) {

		logger.info(SLACK, "This is info message.");
		logger.debug(SLACK, "This is debug message.");
		logger.warn(SLACK, "This is warn message.");

		SlackApi api = new SlackApi("https://hooks.slack.com/services/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");
		api.call(new SlackMessage(appendLog()));
	}

	private static String appendLog() {
		StringBuilder builder = null;
		InputStream inputStream = null;

		builder = new StringBuilder();

		try {
			inputStream = new FileInputStream(new File(LOG_FILE));
			int line;
			while ((line = inputStream.read()) != -1) {
				builder.append((char) line);
			}
			// Thread.currentThread().wait(100);
		} catch (Throwable cause) {
			cause.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return builder.toString();
	}
}
