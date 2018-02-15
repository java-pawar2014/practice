package com.springmvc.simpleform.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.springmvc.simpleform.bean.EmployeeBean;

/**
 * @author bpawar
 *
 */
public class EmployeeDAO {

	private final String INSERT_EMPLOYEE = "INSERT INTO employee(first_name, last_name, birth_date, designation, city, email, contact) values (?, ?, ?, ?, ?, ?, ?)";

	private SimpleJdbcInsert jdbcInsert;
	private JdbcTemplate jdbcTemplate;
	private EmployeeBean employee;

	public EmployeeBean insertEmployee(EmployeeBean employee) {

		this.employee = employee;

		return jdbcTemplate.execute(new EmployeeInsertPstmtCreator(), new EmployeeInsertPstmtCallback());
	}

	private final class EmployeeInsertPstmtCreator implements PreparedStatementCreator {

		@Override
		public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setDate(3, new Date(employee.getBirthDate().getTime()));
			preparedStatement.setString(4, employee.getDesignation());
			preparedStatement.setString(5, employee.getCity());
			preparedStatement.setString(6, employee.getEmail());
			preparedStatement.setString(7, employee.getContact());
			return preparedStatement;
		}
	}

	private final class EmployeeInsertPstmtCallback implements PreparedStatementCallback<EmployeeBean> {
		@Override
		public EmployeeBean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
			return null;
		}
	}

	private Map<String, Object> sourceMap(EmployeeBean employee) {
		Map<String, Object> sourceMap = null;

		sourceMap = new ConcurrentHashMap<String, Object>();
		sourceMap.put("first_name", employee.getFirstName());
		sourceMap.put("last_name", employee.getLastName());
		sourceMap.put("birth_date", employee.getBirthDate());
		sourceMap.put("designation", employee.getDesignation());
		sourceMap.put("city", employee.getCity());
		sourceMap.put("email", employee.getEmail());
		sourceMap.put("contact", employee.getContact());
		return sourceMap;
	}

	public void setJdbcInsert(SimpleJdbcInsert jdbcInsert) {
		this.jdbcInsert = jdbcInsert;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}