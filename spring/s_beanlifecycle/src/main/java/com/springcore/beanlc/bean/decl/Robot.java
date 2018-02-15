package com.springcore.beanlc.bean.decl;

/**
 * @author bpawar
 *
 */
public class Robot {

	private String name;
	private SensorDriver sensorDriver;

	/**
	 * One injection by constructor
	 * 
	 * @param sensorDriver
	 */
	public Robot(SensorDriver sensorDriver) {
		System.out.println("Invoking Robot(SensorDriver)");
		this.sensorDriver = sensorDriver;
	}

	public String getName() {
		return name;
	}

	/**
	 * Another injection by setter
	 * 
	 * @param name
	 */
	public void setName(String name) {
		System.out.println("Invoking setName(String)");
		this.name = name;
	}

	/**
	 * initialization activities after both injections.
	 */
	public void startup() {
		System.out.println("Starting functionalities of robot...");
		System.out.println("Driver type: " + sensorDriver.getType());
		System.out.println("Driver name: " + name);
	}

	/**
	 * Destroy functionalities
	 */
	public void release() {
		System.out.println("releasing resources...");
	}
}
