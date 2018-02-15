package com.springcore.factoryprocessor.bean;

/**
 * @author bpawar
 *
 */
public class ConnectionManager {

	private String databaseURL;
	private String username;
	private String password;

	public String getDatabaseURL() {
		return databaseURL;
	}

	public void setDatabaseURL(String databaseURL) {
		this.databaseURL = databaseURL;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ConnectionManager [databaseURL=" + databaseURL + ", username=" + username + ", password=" + password
				+ "]";
	}
}