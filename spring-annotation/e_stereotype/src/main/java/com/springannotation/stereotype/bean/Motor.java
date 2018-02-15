package com.springannotation.stereotype.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author bpawar
 *
 */
@Component(value = "motor")
@Scope(value = "prototype")
public class Motor {

	@Autowired
	private Engine engine;

	public void run() {
		System.out.println("Staring motor with engine : " + engine);
	}
}
