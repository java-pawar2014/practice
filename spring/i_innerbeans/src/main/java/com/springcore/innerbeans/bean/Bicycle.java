package com.springcore.innerbeans.bean;

public class Bicycle {

	private String modelCode;
	private String modelName;
	private float unitPrice;
	private Chain chain;

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Chain getChain() {
		return chain;
	}

	public void setChain(Chain chain) {
		this.chain = chain;
	}

	@Override
	public String toString() {
		return "Bicycle [modelCode=" + modelCode + ", modelName=" + modelName + ", unitPrice=" + unitPrice + ", chain="
				+ chain + "]";
	}
}
