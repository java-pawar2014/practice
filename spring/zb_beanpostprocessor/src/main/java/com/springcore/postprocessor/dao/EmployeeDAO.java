package com.springcore.postprocessor.dao;

import com.springcore.postprocessor.bean.EmployeeVO;

public class EmployeeDAO {

	public void save(EmployeeVO employee) {
		System.out.println("Inserted employee " + employee.getName() + " on " + employee.getLastModifiedDate());
	}
}
