<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new product</title>
</head>
<body>
	<div style="margin-top: 40px;" align="center">
		<h2 align="center">Add new product</h2>
		<form action="${pageContext.request.contextPath}/addProduct"
			method="post">
			<table align="center" border="1">
				<tbody>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name" value="${product.name}"
							required></td>
					</tr>
					<tr>
						<td>Price</td>
						<td><input type="text" name="name" value="${product.price}"
							required></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Save">&nbsp;&nbsp;&nbsp;<input type="reset"
							value="Reset"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div align="center" style="margin-top: 25px;">
		<div>
			<a href="${pageContext.request.contextPath}/products">All
				Products</a>
		</div>
	</div>
</body>
</html>