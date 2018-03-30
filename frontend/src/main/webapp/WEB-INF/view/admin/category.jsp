<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	${categorySuccessMessage} ${categoryErrorMessage}
	<form action="category/save/" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name='id' value="${selectedCategory.id}" ></td>
			</tr>
			<tr>
			<td>Name</td>
			<td><input type="text" name='name'value="${selectedCategory.name}"></td>
			</tr>
			<tr>
			<td>Description</td>
			<td><input type="text" name='description' value="${selectedCategory.description}"></td>
			<tr>
				<td><input type="submit" value='create category'></td>
			</tr>
		</table>
	</form>

	<div>
		<table class="table">
			<tr>
				<td>Category ID</td>
				<td>Category Name</td>
				<td>Category Description</td>
				<td>Action</td>
			</tr>
			<c:forEach var="category" items="${categories}">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="category/delete/?id=${category.id}">Delete</a>|
					<a href="category/edit/?id=${category.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>

</html>