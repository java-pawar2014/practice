<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homepage</title>
</head>
<body>
	<h3>Welcome to Spring Boot Configuration Application</h3>
	<h4>You have configured variables:</h4>
	<h5>${response.response}</h5>
	<ul>
		<li>${name}</li>
		<li>${address}</li>
		<li>${contact}</li>
		<li>${email}</li>
	</ul>
</body>
</html>