package org.spring.profiles.web.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Profile(value = { "development" })
public class DevelopmentHomeController {

	@GetMapping(path = { "/", "/welcome" })
	public ResponseEntity<String> welcome() {

		ResponseEntity<String> response = new ResponseEntity<String>("Development home controller", HttpStatus.OK);

		return response;
	}

}
