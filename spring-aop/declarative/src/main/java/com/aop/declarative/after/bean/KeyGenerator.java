package com.aop.declarative.after.bean;

import java.util.UUID;

/**
 * @author bpawar
 *
 */
public class KeyGenerator {
	
	public String generateKey(int length) {
		StringBuilder key = null;
		key = new StringBuilder();
		key.append(UUID.randomUUID());

		if (length < 36) {
			return key.toString().substring(0, length).toUpperCase();
		}
		return null;
	}
}
