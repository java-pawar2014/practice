package com.springcore.factorybean.bean;

import java.util.Calendar;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author bpawar
 *
 */
public class CalendarFactoryBean implements FactoryBean<Calendar> {

	private int day, month, year, hourOfDay, minute, second;

	public CalendarFactoryBean(int day, int month, int year, int hourOfDay, int minute, int second) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.hourOfDay = hourOfDay;
		this.minute = minute;
		this.second = second;
	}

	@Override
	public Calendar getObject() throws Exception {
		System.out.println("Invoked getObject()");

		Calendar calendar = null;

		calendar = Calendar.getInstance();
		calendar.set(year, month, day, hourOfDay, minute, second);
		return calendar;
	}

	@Override
	public Class<?> getObjectType() {
		System.out.println("Invoked getObjectType()");
		return Calendar.class;
	}

	@Override
	public boolean isSingleton() {
		System.out.println("Invoked isSingleton()");
		return true;
	}
}
