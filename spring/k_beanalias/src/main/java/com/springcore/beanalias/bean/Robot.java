package com.springcore.beanalias.bean;

public class Robot {

	private String robotId;
	private String robotName;

	public String getRobotId() {
		return robotId;
	}

	public void setRobotId(String robotId) {
		this.robotId = robotId;
	}

	public String getRobotName() {
		return robotName;
	}

	public void setRobotName(String robotName) {
		this.robotName = robotName;
	}

	@Override
	public String toString() {
		return "Robot [robotId=" + robotId + ", robotName=" + robotName + "]";
	}
}
