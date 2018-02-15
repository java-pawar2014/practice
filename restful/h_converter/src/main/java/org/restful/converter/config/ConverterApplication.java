package org.restful.converter.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.restful.converter.provider.BeanConverterProvider;
import org.restful.converter.resource.FlightStatus;

@ApplicationPath("/")
public class ConverterApplication extends ResourceConfig {

	public ConverterApplication() {

		// Register resources and providers using package-scanning.
		// packages("org.restful.converter.provider",
		// "org.restful.converter.resource");

		// Register my custom provider - not needed if it's in above packages.
		// Either by creating objects
		register(new BeanConverterProvider());
		register(new FlightStatus());

		// OR by adding classes
		// register(BeanConverterProvider.class);
		// register(FlightStatus.class);
	}
}
