package org.spring.bootconfig.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class EnvironmentPropertiesConfiguration {

	private List<String> properties = new ArrayList<String>();

	public List<String> getProperties() {
		return properties;
	}
}
