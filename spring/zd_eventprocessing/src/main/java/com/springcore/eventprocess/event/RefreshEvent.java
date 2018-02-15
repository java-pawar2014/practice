package com.springcore.eventprocess.event;

import org.springframework.context.ApplicationEvent;

public class RefreshEvent extends ApplicationEvent {

	private static final long serialVersionUID = -6549037175172363819L;

	private String tableName;

	public RefreshEvent(Object source, String tableName) {
		super(source);
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
