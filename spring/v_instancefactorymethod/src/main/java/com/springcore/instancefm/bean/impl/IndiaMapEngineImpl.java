package com.springcore.instancefm.bean.impl;

import com.springcore.instancefm.bean.MapEngine;

public class IndiaMapEngineImpl implements MapEngine {

	public String[] getDirection(String source, String destination) {

		return new String[] { source, "-def", "-ghi", "-pqr-", destination };
	}
}
