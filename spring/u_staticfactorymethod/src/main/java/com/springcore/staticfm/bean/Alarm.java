package com.springcore.staticfm.bean;

import java.util.Calendar;

public class Alarm {

	private Calendar calendar;

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public void irritate() {
		System.out.println("Daily irritating at " + calendar.getTime());
	}
}
