package com.springcore.postprocessor.delegate;

import com.springcore.postprocessor.bean.EmployeeVO;
import com.springcore.postprocessor.dao.EmployeeDAO;

public abstract class EmployeeDelegate {

	private EmployeeDAO employeeDAO;
	private EmployeeVO employeeVO;

	public void save() {
		employeeVO = getEmployeeVO();
		employeeVO.setEmployeeId("EMP001");
		employeeVO.setName("John");
		employeeVO.setSalary(62000.0F);
		employeeDAO.save(employeeVO);
	}

	public abstract EmployeeVO getEmployeeVO();

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

}
