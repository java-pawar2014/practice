package com.springcore.consconf.bean;

import java.beans.ConstructorProperties;

public class Robot {
	private int robotMfgId;
	private String robotName;
	private String robotType;

	/**
	 * Uses specified constructor properties in resolving constructor argument
	 * confusion by using 'name' property of <tag><constructor-arg></tag>
	 * 
	 * @param robotMfgId
	 * @param robotName
	 */
	@ConstructorProperties(value = { "robotMfgId", "robotName" })
	public Robot(int robotMfgId, String robotName) {
		System.out.println("Invoked int, String.");
		this.robotMfgId = robotMfgId;
		this.robotName = robotName;
	}

	@ConstructorProperties(value = { "robotName", "robotType" })
	public Robot(String robotName, String robotType) {
		System.out.println("Invoked String, String.");
		this.robotName = robotName;
		this.robotType = robotType;
	}

	@Override
	public String toString() {
		return "Robot [robotMfgId=" + robotMfgId + ", robotName=" + robotName + ", robotType=" + robotType + "]";
	}
}
