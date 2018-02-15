package com.springannotation.qualifier.bean;

public class Engine {

	private String engineSerial;
	private String engineType;

	public Engine() {
		// TODO Auto-generated constructor stub
	}

	public Engine(String engineSerial, String engineType) {
		super();
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
