<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
</head>
<body onload='document.loginForm.username.focus();'>

	<h2 align="center">Spring Security Custom Login Form</h2>

	<div id="login-box">

		<h2>Login with Username and Password</h2>

		<core:if test="${not empty error}">
			<div class="error">${error}</div>
		</core:if>
		<core:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</core:if>

		<form name='loginForm' action="<core:url value='j_spring_security_check' />" method='POST'>

			<table>
				<tr>
					<td align="right">User:</td>
					<td>
						<input type='text' name='username' value='' required/>
					</td>
				</tr>
				<tr>
					<td align="right">Password:</td>
					<td>
						<input type='password' name='password' required/>
					</td>
				</tr>
				<tr>
					<td colspan='2' align="center">
						<input name="submit" type="submit" value="Login" /> &nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" value="Clear" />
					</td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

		</form>
	</div>

</body>
</html>
