/**
 * 
 */
package com.aop.programmatic.after.service;

import java.util.Random;

/**
 * @author bpawar
 *
 */
public class KeyGenerator {

	public int generateKey() {

		return new Random().nextInt();

	}
}
