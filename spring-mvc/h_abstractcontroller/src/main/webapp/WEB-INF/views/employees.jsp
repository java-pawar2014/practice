<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of employees</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Sr. No.</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>City</th>
				<th>Phone</th>
			</tr>
		</thead>
		<tbody>
			<core:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.employeeId}</td>
					<td>${employee.firstName}</td>
					<td>${employee.lastName}</td>
					<td>${employee.city}</td>
					<td>${employee.phone}</td>
				</tr>
			</core:forEach>
		</tbody>
	</table>
</body>
</html>