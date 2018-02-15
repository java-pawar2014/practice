package com.springannotation.required.bean;

import org.springframework.beans.factory.annotation.Required;

/**
 * @author bpawar
 *
 */
public class Engine {

	private String engineSerial;
	private String engineType;

	public String getEngineSerial() {
		return engineSerial;
	}

	@Required
	public void setEngineSerial(String engineSerial) {
		this.engineSerial = engineSerial;
	}

	public String getEngineType() {
		return engineType;
	}

	@Required
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	@Override
	public String toString() {
		return "Engine [engineSerial=" + engineSerial + ", engineType=" + engineType + "]";
	}
}