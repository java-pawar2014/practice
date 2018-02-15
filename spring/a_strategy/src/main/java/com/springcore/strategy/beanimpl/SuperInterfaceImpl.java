package com.springcore.strategy.beanimpl;

import com.springcore.strategy.bean.SuperInterface;

public abstract class SuperInterfaceImpl implements SuperInterface {

	public void method1() {
		System.out.println(VARIABLE);
		System.out.println("Executed method1() of SuperInterface.");
	}
}
