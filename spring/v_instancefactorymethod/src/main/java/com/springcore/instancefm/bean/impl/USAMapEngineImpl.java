package com.springcore.instancefm.bean.impl;

import com.springcore.instancefm.bean.MapEngine;

public class USAMapEngineImpl implements MapEngine {

	public String[] getDirection(String source, String destination) {

		return new String[] { source, "-abc", "-lmn", "-xyz-", destination };
	}
}
