package com.springboot.mongodb.service;

import java.util.List;

import com.springboot.mongodb.bean.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	Employee update(String employeeId, Employee employee);

	Employee deactivate(String employeeId);

	Employee active(String employeeId);

	List<Employee> search();

	Employee search(String employeeId);

}
