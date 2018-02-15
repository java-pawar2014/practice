package com.springcore.awareinterf.bean.impl;

import com.springcore.awareinterf.bean.Engine;

/**
 * @author bpawar
 *
 */
public class TataEngineImpl implements Engine {

	@Override
	public void start() {
		System.out.println("Starting TATA engine...");
	}
}
