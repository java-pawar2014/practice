package org.restful.serverresponse.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDateUtility {

	private static final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");

	public static Date stringToDate(String source) throws Exception {
		Date parsedDate = null;
		
		if (source != null && !source.isEmpty()) {
			parsedDate = format.parse(source);
		}
		return parsedDate;
	}

	@SuppressWarnings("deprecation")
	public static String dateToString(Date date) {
		StringBuilder dateBuilder = null;
		String convertedDate = null;
		
		if (date != null) {
			dateBuilder = new StringBuilder();
			dateBuilder.append(date.getMonth() + 1).append("/").append(date.getDate()).append("/")
					.append(date.getYear() + 1900).append(" ").append(date.getHours()).append(":")
					.append(date.getMinutes());
			convertedDate = dateBuilder.toString();
		}
		return convertedDate;
	}
}
