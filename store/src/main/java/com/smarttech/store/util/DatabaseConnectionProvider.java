package com.smarttech.store.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.Properties;

/**
 * @author bpawar
 * @since Aug 18, 2018
 */
public class DatabaseConnectionProvider {

	private static Connection connection;

	private static Connection createConnection() throws Exception {

		if (Objects.isNull(connection)) {
			synchronized (DatabaseConnectionProvider.class) {
				if (Objects.isNull(connection)) {
					Properties databaseProperties = PropertiesReader.getDatabaseProperties();
					Class.forName(databaseProperties.getProperty("db.driver.class"));
					connection = DriverManager.getConnection(databaseProperties.getProperty("db.url"),
							databaseProperties.getProperty("db.username"),
							databaseProperties.getProperty("db.password"));
				}
			}
		}
		return connection;
	}

	public static Connection getConnection() throws Exception {
		return createConnection();
	}

}
