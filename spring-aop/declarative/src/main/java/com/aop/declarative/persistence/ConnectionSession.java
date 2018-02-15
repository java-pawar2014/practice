package com.aop.declarative.persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.aop.declarative.variable.Constant;

/**
 * @author bpawar
 *
 */
public class ConnectionSession {

	private static ThreadLocal<Connection> connections = new ThreadLocal<Connection>();

	private static Connection connection() {
		if (connections.get() == null) {
			try {
				Properties properties = new Properties();
				properties.load(new FileInputStream(Constant.DATABASE_FILE));
				Class.forName(properties.getProperty(Constant.DRIVER_CLASS));
				Connection connection = DriverManager.getConnection(properties.getProperty(Constant.DATABSE_URL),
						properties.getProperty(Constant.USERNAME), properties.getProperty(Constant.PASSWORD));
				connections.set(connection);
			} catch (IOException | SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return connections.get();
	}

	public static Connection getConnection() {
		return connection();
	}
}