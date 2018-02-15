package com.springcore.eventprocess.source;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.springcore.eventprocess.event.RefreshEvent;

public class RefreshEventSource implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher eventPublisher;

	public void raiseRefresh(String tableName) {
		eventPublisher.publishEvent(new RefreshEvent(this, tableName));
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
	}

	public ApplicationEventPublisher getEventPublisher() {
		return eventPublisher;
	}

	public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}
}
