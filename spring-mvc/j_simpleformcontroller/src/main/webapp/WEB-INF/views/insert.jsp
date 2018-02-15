<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New employee</title>
<style type="text/css">
table {
	margin-top: 20px;
	border: 1px solid black;
}

table tr td {
	width: 10em;
}
form:input {
	width: 100%;
}

h2 {
	margin-top: 30px;
	text-align: center;
}
.error {
	color: red;
}
</style>
</head>
<body>
	<h2>New Employee</h2>

	<form:form commandName="employee" action="insert.htm" method="post">

		<table align="center">
			<tbody>
				<core:if test="${not empty message}">
					<tr>
						<td colspan="3">${message}</td>
					</tr>
				</core:if>
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" /></td>
					<td class="error"><form:errors path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
					<td class="error"><form:errors path="lastName" /></td>
				</tr>
				<tr>
					<td>Birth Date</td>
					<td><form:input path="birthDate" placeholder="dd/MM/yyyy"/></td>
					<td class="error"><form:errors path="birthDate" /></td>
				</tr>
				<tr>
					<td>Designation</td>
					<td><form:input path="designation" /></td>
					<td class="error"><form:errors path="designation" /></td>
				</tr>
				<tr>
					<td>City</td>
					<td><form:input path="city" /></td>
					<td class="error"><form:errors path="city" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
					<td class="error"><form:errors path="email" /></td>
				</tr>
				<tr>
					<td>Contact</td>
					<td><form:input path="contact" /></td>
					<td class="error"><form:errors path="contact" /></td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Add" /> &nbsp; &nbsp; &nbsp; 
						<input type="reset" value="Clear">
					</td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>