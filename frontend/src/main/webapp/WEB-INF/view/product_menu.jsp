<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<ul class="nav nav-pills" role="tablist">
			<c:forEach items="${categories}" var="category">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> ${category.name} <span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<c:forEach items="${category.products}" var="product">
							<li><a href="${root}/productget/${product.id}">${product.name}</a></li>
						</c:forEach>
					</ul></li>
			</c:forEach>
		</ul>
	</div>
	<hr color="blue" width="100" >
	${category.products}
</body>
</html>