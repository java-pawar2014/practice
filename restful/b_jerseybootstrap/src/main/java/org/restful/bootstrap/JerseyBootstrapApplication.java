package org.restful.bootstrap;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class JerseyBootstrapApplication extends ResourceConfig {

	public JerseyBootstrapApplication() {
		packages("org.restful.bootstrap.resource");
	}

}
