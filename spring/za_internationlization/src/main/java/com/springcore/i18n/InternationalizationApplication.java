package com.springcore.i18n;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InternationalizationApplication {

	public static void main(String[] args) {

		ApplicationContext container = new ClassPathXmlApplicationContext("application-context.xml");
		System.out.println("Message : " + container.getMessage("HOME_WELCOME_MSG_CHINA", null, Locale.US));
	}
}
