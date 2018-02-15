package com.aop.programmatic.around.service;

public class Calculator {

	public Calculator() {
	}

	public int add(int arg1, int arg2) {
		System.out.println("inside add(int arg1, int arg2)");
		return arg1 + arg2;
	}

	public int add(int arg1, int arg2, int arg3) {
		System.out.println("inside add(int arg1, int arg2, int arg3)");
		return arg1 + arg2 + arg3;
	}

	public int multiply(int arg1, int arg2) {
		System.out.println("multiply(int arg1, int arg2)");
		return arg1 * arg2;
	}

	public float divide(int arg1, int arg2) {
		System.out.println("divide(int arg1, int arg2)");
		if (arg2 > 0 == false) {
			System.exit(0);
		}
		return arg1 / arg2;
	}
}
