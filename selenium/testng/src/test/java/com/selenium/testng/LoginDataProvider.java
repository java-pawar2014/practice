package com.selenium.testng;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

	@DataProvider(name = "loginDataProvider", parallel = true)
	public String[][] loginData() {
		return new String[][] { { "bpawar@agsft.com", "******" } };
	}
}
