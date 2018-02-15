package com.springcore.factorybean.bean;

import java.util.Calendar;

/**
 * @author bpawar
 *
 */
public class Alarm {

	private Calendar calendar;

	public void irritate() {
		System.out.println("Irritate me at " + calendar.getTime());
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
}
