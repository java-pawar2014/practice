package com.springcore.dependcheck.bean;

public class Motor {

	private Engine engine;

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Motor [engine=" + engine + "]";
	}
}
