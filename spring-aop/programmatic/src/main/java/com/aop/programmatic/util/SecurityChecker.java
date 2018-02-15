package com.aop.programmatic.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aop.programmatic.before.bean.UserBean;
import com.aop.programmatic.persistence.ConnectionSession;

/**
 * @author bpawar
 *
 */
public class SecurityChecker {

	private static final String SELECT_USER = "SELECT password AS password FROM tbl_user WHERE username=?";

	private ThreadLocal<UserBean> userBeans;

	public SecurityChecker() {
		userBeans = new ThreadLocal<UserBean>();
	}

	public void login(String username, String password) {
		UserBean userBean = null;

		userBean = new UserBean(username, password);
		// Store username and password of current execution thread into thread
		// local variable
		userBeans.set(userBean);
	}

	public void logout() {
		userBeans.set(null);
	}

	public boolean authenticate() {
		UserBean userBean = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		userBean = userBeans.get();
		if (userBean == null)
			return false;
		connection = ConnectionSession.getConnection();
		try {
			statement = connection.prepareStatement(SELECT_USER);
			statement.setString(1, userBean.getUsername());
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String password = resultSet.getString("password");
				if (userBean.getPassword().equals(password)) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getLoggedUser() {
		if (userBeans != null) {
			return userBeans.get().getUsername();
		}
		return null;
	}
}
