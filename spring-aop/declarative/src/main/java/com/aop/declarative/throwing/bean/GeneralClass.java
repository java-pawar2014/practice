package com.aop.declarative.throwing.bean;

/**
 * @author bpawar
 *
 */
public class GeneralClass {

	public void stringLength(String... args) throws IndexOutOfBoundsException {

		if (args.length < 2) {
			throw new ArrayIndexOutOfBoundsException(
					"Provided strings are less than expected, length is: " + args.length);
		}

		for (int i = 0; i < args.length; i++) {
			if (args[i].length() <= 2) {
				throw new StringIndexOutOfBoundsException("String length: " + args[i].length());
			}
			System.out.println("String : " + args[i]);
		}
	}
}
