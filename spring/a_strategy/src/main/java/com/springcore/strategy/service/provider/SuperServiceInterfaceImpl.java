package com.springcore.strategy.service.provider;

import com.springcore.strategy.bean.SuperInterface;
import com.springcore.strategy.service.SuperServiceInterface;

public class SuperServiceInterfaceImpl implements SuperServiceInterface {

	private SuperInterface superInterface;

	public void serviceMethod1() {
		System.out.println("Executed serviceMethod1() of SuperServiceInterface.");
		superInterface.method1();
		superInterface.method2();
	}

	public void setSuperInterface(SuperInterface superInterface) {
		this.superInterface = superInterface;
	}

	public SuperInterface getSuperInterface() {
		return superInterface;
	}

}
