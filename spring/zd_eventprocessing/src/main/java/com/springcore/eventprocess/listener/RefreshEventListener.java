package com.springcore.eventprocess.listener;

import org.springframework.context.ApplicationListener;

import com.springcore.eventprocess.event.RefreshEvent;

public class RefreshEventListener implements ApplicationListener<RefreshEvent> {
	
	@Override
	public void onApplicationEvent(RefreshEvent event) {
		System.out.println("Refreshing table : " + event.getTableName());
	}
}
