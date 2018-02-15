package org.restful.bootstrap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.restful.bootstrap.resource.PlanResource;

@ApplicationPath("/")
public class ResteasyBootstrapping extends Application {

	private Set<Object> singletons;

	public ResteasyBootstrapping() {

		singletons = new HashSet<Object>();
		singletons.add(new PlanResource());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

	@Override
	public Set<Class<?>> getClasses() {
		return super.getClasses();
	}

	@Override
	public Map<String, Object> getProperties() {
		return super.getProperties();
	}
}
