package org.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	public WelcomeController() {
		System.out.println("WelcomeController created...");
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "Hello Spring Boot";
	}
}
