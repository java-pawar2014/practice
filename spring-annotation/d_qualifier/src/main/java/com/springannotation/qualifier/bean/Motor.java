package com.springannotation.qualifier.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author bpawar
 *
 */
public class Motor {

	private Engine engine;

	public Engine getEngine() {
		return engine;
	}

	@Autowired
	@Qualifier(value = "engine1")
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void run() {
		System.out.println("Starting motor with engine: " + engine);
	}
}