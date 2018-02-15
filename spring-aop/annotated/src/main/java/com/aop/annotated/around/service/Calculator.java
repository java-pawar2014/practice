package com.aop.annotated.around.service;

import org.springframework.stereotype.Component;

@Component("calculator")
public class Calculator {

	public int add(int arg1, int arg2) {

		return arg1 + arg2;
	}

	public int add(int arg1, int arg2, int arg3) {

		return arg1 + arg2 + arg3;
	}

	public int add(int arg1, int arg2, int arg3, int arg4) {

		return arg1 + arg2 + arg3 + arg4;
	}

	public int sub(int arg1, int arg2) {

		return arg2 - arg1;
	}

	public int sub(int arg1, int arg2, int arg3) {

		return arg3 - arg2 - arg1;
	}
}
