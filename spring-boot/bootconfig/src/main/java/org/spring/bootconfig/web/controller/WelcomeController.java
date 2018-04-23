package org.spring.bootconfig.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.bootconfig.web.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	private Log logger = LogFactory.getLog(WelcomeController.class);

	@Autowired
	private Environment environmentVariables;

	@GetMapping(path = { "/", "/welcome" })
	public HttpEntity<Person> welcome() {

		environmentVariables.acceptsProfiles(new String[] { "dev", "prod" });
		String name = environmentVariables.getProperty("name");
		String address = environmentVariables.getProperty("address");
		String contact = environmentVariables.getProperty("contact");
		String email = environmentVariables.getProperty("email");
		Person responseBody = new Person(name, address, contact, email);
		ResponseEntity<Person> response = new ResponseEntity<Person>(responseBody, HttpStatus.OK);
		return response;
	}
}
