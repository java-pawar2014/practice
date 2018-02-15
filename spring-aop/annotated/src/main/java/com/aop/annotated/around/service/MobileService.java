package com.aop.annotated.around.service;

import org.springframework.stereotype.Component;

@Component("mobileService")
public class MobileService {

	public String getMobileUserName(String mobileNumber) {
		return "User " + mobileNumber;
	}
}
