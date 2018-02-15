package com.sourcing.provider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Read configuration file from classpath <code>config.properties</code> and
 * make available for all by storing into <i>properties</i> instance.
 * 
 * @author bpawar
 *
 */
public class ConfigReader {

	private static String CONFIG_FILE = "config.properties";
	private static Properties properties = null;

	private static String getValue(String key) {
		String value = null;
		if (properties == null) {
			try {
				properties = new Properties();
				properties.load(new FileInputStream(CONFIG_FILE));
			} catch (IOException e) {
				System.out.println("Error reading " + CONFIG_FILE + " file.");
			}
		}
		value = properties.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Key \"" + key + "\" not found in " + CONFIG_FILE + ".");
		}
		return value;
	}

	public static String getConfigPropertyVal(String key) {

		return getValue(key);
	}
}
