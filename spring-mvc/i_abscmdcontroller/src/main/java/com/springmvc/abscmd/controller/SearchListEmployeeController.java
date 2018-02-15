package com.springmvc.abscmd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.springmvc.abscmd.bean.Employee;
import com.springmvc.abscmd.service.EmployeeService;

/**
 * @author bpawar
 *
 */
@SuppressWarnings("deprecation")
public class SearchListEmployeeController extends AbstractCommandController {

	private EmployeeService employeeService;

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {

		ModelAndView modelAndView = null;
		Employee employee = null;

		employee = (Employee) command;
		modelAndView = new ModelAndView();
		modelAndView.addObject("employees", employeeService.employees(employee));
		modelAndView.setViewName("search-result");

		return modelAndView;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}