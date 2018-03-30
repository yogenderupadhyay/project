<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		${productSuccessMessage} ${productErrorMessage}
		${successMessage} ${errorMessage}
	<form action="product/save/" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name='id' value="${selectedProduct.id}"></td>
			</tr>
			<tr>
			<td>Name</td>
			<td><input type="text" name='name' value="${selectedProduct.name}"></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name='description' value="${selectedProduct.description}"></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price"	value="${selectedProduct.price}">
			</tr>
			<tr>
			<td>product image </td>
			<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td>Select Category</td>
				<td><select name="categoryID">
						<c:forEach var="category" items="${categories}">
							<option value="${category.id}" >${category.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Select Supplier</td>
				<td><select name="supplierID">
						<c:forEach var="supplier" items="${suppliers}">
							<option value="${supplier.id}" >${supplier.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value='create product'></td>
			</tr>
		</table>
	</form>

	<div>
		<table class="table">
			<tr>
				<td>Product ID</td>
				<td>Product Name</td>
				<td>Product Description</td>
				<td>Action</td>
			</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td><a href="product/delete/?id=${product.id}">Delete</a>|
					<a href="product/edit/?id=${product.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>