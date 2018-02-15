package com.springmvc.simpleform.service;

import com.springmvc.simpleform.bean.EmployeeBean;
import com.springmvc.simpleform.dao.EmployeeDAO;

public class EmployeeService {

	private EmployeeDAO employeeDAO;

	public EmployeeBean saveEmployee(EmployeeBean employee) {

		return employeeDAO.insertEmployee(employee);
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
}
