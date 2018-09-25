package com.smarttech.store.util;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * @author bpawar
 * @since Aug 18, 2018
 */
public class PropertiesReader {

	private static final String DATABASE_FILE = "database.properties";

	private static Properties databaseProperties;

	public static Properties getDatabaseProperties() throws IOException {
		return readDatabaseProperties();
	}

	private static Properties readDatabaseProperties() throws IOException {
		if (Objects.isNull(databaseProperties)) {
			synchronized (PropertiesReader.class) {
				if (Objects.isNull(databaseProperties)) {
					databaseProperties = readProperties(DATABASE_FILE);
				}
			}
		}
		return databaseProperties;
	}

	private static Properties readProperties(String fileName) throws IOException {
		Properties properties = new Properties();
		properties.load(PropertiesReader.class.getClassLoader().getResourceAsStream(fileName));
		return properties;
	}

}
