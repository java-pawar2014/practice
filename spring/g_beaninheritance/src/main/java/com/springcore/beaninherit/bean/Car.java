package com.springcore.beaninherit.bean;

public class Car {

	private int modelId;
	private String modelName;
	private String engineType;
	private String engineModel;
	private String classType;

	public Car() {
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getEngineModel() {
		return engineModel;
	}

	public void setEngineModel(String engineModel) {
		this.engineModel = engineModel;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Car(int modelId, String modelName, String engineType, String engineModel, String classType) {
		this.modelId = modelId;
		this.modelName = modelName;
		this.engineType = engineType;
		this.engineModel = engineModel;
		this.classType = classType;
	}

	@Override
	public String toString() {
		return "Car [modelId=" + modelId + ", modelName=" + modelName + ", engineType=" + engineType + ", engineModel="
				+ engineModel + ", classType=" + classType + "]";
	}
}
