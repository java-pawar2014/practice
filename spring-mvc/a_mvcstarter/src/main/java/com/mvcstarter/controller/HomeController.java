package com.mvcstarter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author bpawar
 *
 */
public class HomeController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView modelAndView = null;

		modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		
		return modelAndView;
	}
}
