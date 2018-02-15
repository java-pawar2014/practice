package com.springcore.beanlc.bean.prog;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author bpawar
 *
 */
public class Robot implements InitializingBean, DisposableBean {

	private String name;
	private SensorDriver sensorDriver;

	public Robot(SensorDriver sensorDriver) {
		super();
		System.out.println("Invoking Robot(SensorDriver)");
		this.sensorDriver = sensorDriver;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Invoking setName(String)");
		this.name = name;
	}

	/**
	 * Invokes at destroying this singleton bean for cleanup
	 * 
	 * @throws Exception
	 *             in case of shutdown errors. Exceptions will get logged but not
	 *             rethrown to allow other beans to release their resources too.
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("Performing cleanup activities...");
	}

	/**
	 * Gets invoked after initializing object by calling constructor and setters for
	 * post initialization and post activities
	 * 
	 * @throws Exception
	 *             in the event of mis-configuration (such as failure to set an
	 *             essential property) or if initialization fails.
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Performaing initialization...");
		System.out.println("Driver name: " + name + "\ttype: " + sensorDriver.getType());
	}
}
