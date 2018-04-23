package org.spring.basicwebsecurity.initializer;

import org.spring.basicwebsecurity.config.SecurityConfiguration;
import org.spring.basicwebsecurity.config.WebMvcConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@EnableWebMvc
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public Class<?>[] getRootConfigClasses() {

		return new Class[] { SecurityConfiguration.class };
	}

	@Override
	public Class<?>[] getServletConfigClasses() {

		return new Class[] { WebMvcConfiguration.class };
	}

	@Override
	public String[] getServletMappings() {

		return new String[] { "/" };
	}
}
