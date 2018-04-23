package org.spring.basicwebsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Welcome to Spring Security Web Application");
		modelAndView.addObject("message", "This is welcome page");
		modelAndView.setViewName("welcome");
		return modelAndView;
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Welcome to Spring Security Web Application");
		model.addObject("message", "This is protected - Admin page!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Welcome to Spring Security Web Application");
		model.addObject("message", "This is protected page - Database Page!");
		model.setViewName("dba");

		return model;

	}

	@RequestMapping(value = "/user**", method = RequestMethod.GET)
	public ModelAndView userPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Welcome to Spring Security Web Application");
		model.addObject("message", "This is protected page - User Page!");
		model.setViewName("user");

		return model;

	}

}
