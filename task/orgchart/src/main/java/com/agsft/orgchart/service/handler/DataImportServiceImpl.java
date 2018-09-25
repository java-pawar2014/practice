package com.agsft.orgchart.service.handler;

import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agsft.orgchart.service.IDataImportService;
import com.agsft.orgchart.service.IDepartmentService;
import com.agsft.orgchart.service.IEmployeeService;
import com.agsft.orgchart.service.IRoleService;
import com.agsft.orgchart.util.Reader;
import com.agsft.orgchart.web.model.DepartmentDTO;
import com.agsft.orgchart.web.model.EmployeeDTO;
import com.agsft.orgchart.web.model.RoleDTO;

import lombok.NoArgsConstructor;

/**
 * @author bpawar
 *
 */
@Service
@NoArgsConstructor
public class DataImportServiceImpl implements IDataImportService {

	@Autowired
	private IEmployeeService employeeService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IDepartmentService departmentService;

	@Autowired
	private Reader reader;

	private final String employees = "employees";
	private final String departments = "departments";
	private final String roles = "roles";

	@Override
	public boolean importRawData(InputStream fileStream, String entityType) throws Exception {
		if (entityType.equals(this.employees))
			return importEmployees(fileStream);
		else if (entityType.equals(this.departments))
			return importDepartments(fileStream);
		else if (entityType.equals(this.roles))
			return importRoles(fileStream);
		return false;
	}

	@Override
	public boolean importEmployees(InputStream file) throws Exception {
		List<EmployeeDTO> employees = null;
		try {
			List<Map<String, String>> employeesData = reader.getCsvFileLines(file);
			if (!employeesData.isEmpty()) {
				employees = reader.mapper(employeesData, EmployeeDTO.class);
				if (!employees.isEmpty())
					if (!employeeService.saveAll(employees).isEmpty())
						return true;
			} else
				throw new ParseException("Unable to parse the empty file", 0);
		} catch (Exception cause) {
			throw new ParseException(cause.getMessage(), 0);
		}
		return false;
	}

	@Override
	public boolean importDepartments(InputStream file) throws Exception {
		List<DepartmentDTO> departments = null;
		try {
			List<Map<String, String>> departmentData = reader.getCsvFileLines(file);
			if (!departmentData.isEmpty()) {
				departments = reader.mapper(departmentData, DepartmentDTO.class);
				if (!departments.isEmpty())
					if (!departmentService.saveAll(departments).isEmpty())
						return true;
			} else
				throw new ParseException("Unable to parse the empty file", 0);
		} catch (Exception cause) {
			throw new ParseException(cause.getMessage(), 0);
		}
		return false;
	}

	@Override
	public boolean importRoles(InputStream file) throws Exception {
		List<RoleDTO> roles = null;
		try {
			List<Map<String, String>> rolesData = reader.getCsvFileLines(file);
			if (!rolesData.isEmpty()) {
				roles = reader.mapper(rolesData, RoleDTO.class);
				if (!roles.isEmpty())
					if (!roleService.saveAll(roles).isEmpty())
						return true;
			} else
				throw new ParseException("Unable to parse the empty file", 0);
		} catch (Exception cause) {
			throw new ParseException(cause.getMessage(), 0);
		}
		return false;
	}
}