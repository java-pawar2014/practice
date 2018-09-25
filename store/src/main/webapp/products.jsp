<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<style type="text/css">
td {
	padding: 5px;
}
</style>
</head>
<body>
	<div style="margin-top: 40px; margin-left: 40px">
		<h2 align="center">Products</h2>
		<table align="center" border="1">
			<thead>
				<tr>
					<td>No.</td>
					<td>Name</td>
					<td>Price</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<core:choose>
					<core:when test="${fn:length(products) gt 0}">
						<core:forEach items="${products}" var="product">
							<tr>
								<td><a
									href="${pageContext.request.contextPath}/product?id=${product.id}">${product.id}</a></td>
								<td>${product.name}</td>
								<td>${product.price}</td>
								<td><form
										action="${pageContext.request.contextPath}/deleteProduct"
										method="post">
										<input type="hidden" name="id" value="${product.id}">
										<input type="submit" value="Delete">
									</form></td>
							</tr>
						</core:forEach>
					</core:when>
					<core:otherwise>
						<tr>
							<td colspan="4" style="text-align: center; color: red;">No
								products found</td>
						</tr>
					</core:otherwise>
				</core:choose>
			</tbody>
		</table>
	</div>
	<div align="center" style="margin-top: 25px;">
		<div>
			<a href="${pageContext.request.contextPath}/addProduct">Add
				Product</a>
		</div>
	</div>

</body>
</html>