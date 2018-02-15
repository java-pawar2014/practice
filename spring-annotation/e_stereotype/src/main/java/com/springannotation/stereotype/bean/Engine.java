package com.springannotation.stereotype.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author bpawar
 *
 */
@Component(value = "engine")
@Scope(value = "prototype")
public class Engine {

	private String engineSerial;
	private String engineType;

	public Engine() {
	}

	public Engine(String engineSerial, String engineType) {
		this.engineSerial = engineSerial;
		this.engineType = engineType;
	}

	public String getEngineSerial() {
		return engineSerial;
	}

	public void setEngineSerial(String engineSerial) {
		this.engineSerial = engineSerial;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	@Override
	public String toString() {
		return "Engine [engineSerial=" + engineSerial + ", engineType=" + engineType + "]";
	}
}
