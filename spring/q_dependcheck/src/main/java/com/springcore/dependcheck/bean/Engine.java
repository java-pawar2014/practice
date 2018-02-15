package com.springcore.dependcheck.bean;

public class Engine {

	private String engineCode;
	private String engineModel;
	private String engineType;

	public String getEngineCode() {
		return engineCode;
	}

	public void setEngineCode(String engineCode) {
		this.engineCode = engineCode;
	}

	public String getEngineModel() {
		return engineModel;
	}

	public void setEngineModel(String engineModel) {
		this.engineModel = engineModel;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	@Override
	public String toString() {
		return "Engine [engineCode=" + engineCode + ", engineModel=" + engineModel + ", engineType=" + engineType + "]";
	}
}
