<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>index</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/STYLESHEET.css"/>" >
</head>
<body>
<header>
		<ul id="right">
	  			<li><a href="managecategories"> Manage Categories</a></li> 
	  			<li><a href="managesupplier"> Manage Suppliers</a></li> 
	  			<li><a href="manageproducts">Manage Products</a> </li> 
			</ul>
			</header>
	<br>

	<c:if test="${isAdminClickedManageCategories==true }">
		<jsp:include page="category.jsp"></jsp:include>
	</c:if>
	<c:if test="${isAdminClickedManageSuppliers==true }">
		<jsp:include page="supplier.jsp"></jsp:include>
	</c:if>
	<c:if test="${isAdminClickedManageProducts==true }">
		<jsp:include page="product.jsp"></jsp:include>
	</c:if>
</body>
</html>