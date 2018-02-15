package com.springmvc.simpleform.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.springmvc.simpleform.bean.EmployeeBean;
import com.springmvc.simpleform.service.EmployeeService;

@SuppressWarnings("deprecation")
public class EmployeeInsertController extends SimpleFormController {

	private EmployeeService employeeService;

	@Override
	public Object formBackingObject(HttpServletRequest request) throws Exception {

		return new EmployeeBean();
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {

		if (errors.hasErrors()) {
			return showForm(request, errors, "insert");
		}
		ModelAndView modelAndView = null;
		EmployeeBean employee = null;

		employee = (EmployeeBean) command;

		if (new Date().getTime() < employee.getBirthDate().getTime()) {
			errors.rejectValue("birthDate", "birthDate.earlier");
			return showForm(request, errors, "insert");
		}

		modelAndView = new ModelAndView();
		employee = null;
		employee = employeeService.saveEmployee(employee);
		if (employee != null) {
			modelAndView.addObject("message",
					"Employee details of " + employee.getFirstName() + " " + employee.getLastName());
		} else {
			modelAndView.addObject("message", "Failed to save Employee details.");
		}
		modelAndView.setViewName("insert");

		return modelAndView;
	}

	@Override
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
}
