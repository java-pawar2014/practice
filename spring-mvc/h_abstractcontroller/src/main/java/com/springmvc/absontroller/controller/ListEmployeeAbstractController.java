package com.springmvc.absontroller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.springmvc.absontroller.service.ListEmployeeService;

public class ListEmployeeAbstractController extends AbstractController {

	private ListEmployeeService employeeService;

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelAndView = null;

		modelAndView = new ModelAndView();
		modelAndView.addObject("employees", employeeService.employeeBeans());
		modelAndView.setViewName("employees");

		return modelAndView;
	}

	public void setEmployeeService(ListEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
