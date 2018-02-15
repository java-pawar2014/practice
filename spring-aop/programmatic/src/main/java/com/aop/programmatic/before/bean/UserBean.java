package com.aop.programmatic.before.bean;

/**
 * @author bpawar
 *
 */
public class UserBean {

	private String username;
	private String password;

	public UserBean(String username, String password) {
		super();
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
