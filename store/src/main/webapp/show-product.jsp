<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<body>
	<div style="margin-top: 40px;" align="center">
		<h2 align="center">Product : ${product.name}</h2>
		<form action="${pageContext.request.contextPath}/updateProduct"
			method="post">
			<input type="hidden" name="id" value="${product.id}">
			<table align="center" border="1">
				<tbody>
					<tr>
						<td>No.</td>
						<td><label>${product.id}</label></td>
					</tr>
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
							value="Update">&nbsp;&nbsp;&nbsp;<input type="reset"
							value="Reset"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div align="center">
		<div>
			<a href="${pageContext.request.contextPath}/products">All
				Products</a>
		</div>
		<div>
			<a href="${pageContext.request.contextPath}/addProduct">Add
				Product</a>
		</div>
	</div>
</body>
</html>