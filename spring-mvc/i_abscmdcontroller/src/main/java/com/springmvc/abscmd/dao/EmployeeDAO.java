package com.springmvc.abscmd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.abscmd.bean.Employee;

/**
 * @author bpawar
 *
 */
public class EmployeeDAO {

	private final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee WHERE (first_name IS NOT NULL AND first_name like ?) OR (last_name IS NOT NULL AND last_name like ?) OR (city IS NOT NULL AND city like ?)";

	private JdbcTemplate jdbcTemplate;

	public List<Employee> employees(Employee employee) {

		return jdbcTemplate.query(SELECT_ALL_EMPLOYEE,
				new Object[] { employee.getFirstName(), employee.getLastName(), employee.getCity() },
				new RowMapper<Employee>() {
					@Override
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee employee = new Employee();

						employee.setEmployeeId(rs.getString("emp_id"));
						employee.setFirstName(rs.getString("first_name"));
						employee.setLastName(rs.getString("last_name"));
						employee.setEmail(rs.getString("email"));
						employee.setContact(rs.getString("contact"));
						employee.setCity(rs.getString("city"));
						return employee;
					}
				});
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
