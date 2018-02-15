<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
	prefix="function"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Available employees</title>
<style type="text/css">
table tr th, td {
	width: 10em;
}
</style>
</head>
<body>
	<h2 align="center">Employee Profiles</h2>

	<h3 style="color: navy; text-align: center;">Employees details for
		your search</h3>

	<table align="center" border="1">
		<thead>
			<tr>
				<th>Sr. No.</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Contact</th>
				<th>City</th>
			</tr>
		</thead>
		<tbody>
			<core:choose>
				<core:when test="${function:length(employees) gt 0}">
					<core:forEach items="${employees}" var="employee">
						<tr>
							<td>${employee.employeeId}</td>
							<td>${employee.firstName}</td>
							<td>${employee.lastName}</td>
							<td>${employee.email}</td>
							<td>${employee.contact}</td>
							<td>${employee.city}</td>
						</tr>
					</core:forEach>
				</core:when>
				<core:otherwise>
					<tr>
						<td colspan="6" style="color: red;">No records found.</td>
					</tr>
				</core:otherwise>
			</core:choose>
		</tbody>
	</table>
</body>
</html>