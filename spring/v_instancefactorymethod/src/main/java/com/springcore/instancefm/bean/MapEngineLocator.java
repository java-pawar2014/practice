package com.springcore.instancefm.bean;

import com.springcore.instancefm.bean.impl.IndiaMapEngineImpl;
import com.springcore.instancefm.bean.impl.USAMapEngineImpl;

public class MapEngineLocator {

	public MapEngine getIndiaMapEngine() {
		
		return new IndiaMapEngineImpl();
	}

	public MapEngine getUsaMapEngine() {
		
		return new USAMapEngineImpl();
	}
}
