package org.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LogoutController {

	public LogoutController() {
		System.out.println("LogoutController created...");
	}

	@GetMapping("/logout")
	public String logout() {
		return "You are logged out successfully...!";
	}

}
