package com.aop.declarative.before.bean;

/**
 * @author bpawar
 *
 */
public class UserBean {

	private String username;
	private String password;

	/**
	 * @param username
	 * @param password
	 */
	public UserBean(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
