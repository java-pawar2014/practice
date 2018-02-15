package com.springcore.nullstring.bean;

/**
 * @author bpawar
 *
 */
public class Motor {

	private String motorCode;
	private String modelName;

	public Motor() {
	}

	public Motor(String motorCode, String modelName) {
		this.motorCode = motorCode;
		this.modelName = modelName;
	}

	public String getMotorCode() {
		return motorCode;
	}

	public void setMotorCode(String motorCode) {
		this.motorCode = motorCode;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	@Override
	public String toString() {
		return "Motor [motorCode=" + motorCode + ", modelName=" + modelName + "]";
	}
}
