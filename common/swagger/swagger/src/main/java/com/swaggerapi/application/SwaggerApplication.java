package com.swaggerapi.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.swaggerapi.resource.PlanResource;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@ApplicationPath(value = "/swagger")
public class SwaggerApplication extends Application {

	public SwaggerApplication() {

		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/swagger");
		beanConfig.setResourcePackage("com.swaggerapi.resource");
		beanConfig.setScan(true);
		
		
		
	}

	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> classes = new HashSet<Class<?>>();
		// Swagger initializers
		classes.add(ApiListingResource.class);
		classes.add(SwaggerSerializers.class);
		
		classes.add(PlanResource.class);

		return classes;
	}
}
