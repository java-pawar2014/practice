package com.springmvc.absontroller.service;

import java.util.ArrayList;
import java.util.List;

import com.springmvc.absontroller.bean.EmployeeBean;

public class ListEmployeeService {

	public List<EmployeeBean> employeeBeans() {

		List<EmployeeBean> employeeBeans = null;

		employeeBeans = new ArrayList<EmployeeBean>();
		employeeBeans.add(employeeBean("001", "Rahul", "Joshi", "Pune", "225124251"));
		employeeBeans.add(employeeBean("002", "Paresh", "Patil", "Mumbai", "9968564814"));
		employeeBeans.add(employeeBean("003", "Vishal", "Arora", "Pune", "669544845"));
		employeeBeans.add(employeeBean("004", "Anand", "Anna", "Pune", "2201207894"));
		employeeBeans.add(employeeBean("005", "Sagar", "Ghatge", "Pune", "6698712565"));
		return employeeBeans;
	}

	private EmployeeBean employeeBean(String employeeId, String firstName, String lastName, String city, String phone) {
		EmployeeBean employee = null;

		employee = new EmployeeBean();
		employee.setEmployeeId(employeeId);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setCity(city);
		employee.setPhone(phone);

		return employee;
	}
}
