package com.agsft.testapp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.java.Log;

@Log
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		log.info("Invoked configure(SpringApplicationBuilder)");
		return application.sources(TestappApplication.class);
	}

}
