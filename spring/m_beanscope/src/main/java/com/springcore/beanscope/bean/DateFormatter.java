package com.springcore.beanscope.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	public Date formatDate(String dateString, String pattern) {
		SimpleDateFormat format = null;
		Date formattedDate = null;

		if (dateString != null && pattern != null) {
			format = new SimpleDateFormat(pattern);
			try {
				formattedDate = format.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return formattedDate;
	}
}
