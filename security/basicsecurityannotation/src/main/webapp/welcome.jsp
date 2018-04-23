<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" isELIgnored="false"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<h3>
		Access <a href="${pageContext.request.contextPath}/admin"> ADMIN </a>
		page.
	</h3>
	<h3>
		Access <a href="${pageContext.request.contextPath}/dba"> DBA </a>
		page.
	</h3>
	<h3>
		Access <a href="${pageContext.request.contextPath}/user"> USER </a>
		page.
	</h3>

</body>
</html>