package org.restful.contenthandler.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.restful.contenthandler.resource.BuiltInContentHandlerResource;
import org.restful.contenthandler.resource.JAXBContentHandlerResource;
import org.restful.contenthandler.writer.JAXBUniversalMarshaller;

@ApplicationPath("/")
public class ContentHandlerApplication extends ResourceConfig {

	public ContentHandlerApplication() {

		// registerClasses(BuiltInContentHandlerResource.class,
		// JAXBContentHandlerResource.class, CustomerResolver.class);

		registerClasses(JAXBUniversalMarshaller.class, BuiltInContentHandlerResource.class,
				JAXBContentHandlerResource.class);

		// register(new BuiltInContentHandlerResource());
		// register(new JAXBContentHandlerResource());

	}
}
