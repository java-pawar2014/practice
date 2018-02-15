package com.springmvc.abscmd.service;

import java.util.List;

import com.springmvc.abscmd.bean.Employee;
import com.springmvc.abscmd.dao.EmployeeDAO;

/**
 * @author bpawar
 *
 */
public class EmployeeService {

	private EmployeeDAO employeeDAO;

	public List<Employee> employees(Employee employee) {

		return employeeDAO.employees(employee);
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

}
