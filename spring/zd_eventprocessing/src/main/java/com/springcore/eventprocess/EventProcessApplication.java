package com.springcore.eventprocess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.eventprocess.source.RefreshEventSource;

/**
 * @author bpawar
 *
 */
public class EventProcessApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");

		RefreshEventSource eventSource = applicationContext.getBean(RefreshEventSource.class);

		eventSource.raiseRefresh("tbl_user_config");
	}
}
