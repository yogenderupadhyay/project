<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>index</title>
<link rel="stylesheet" type="text/css"
	href="/resources/css/STYLESHEET.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="row"> 
<c:forEach var="product" items="${products}">
 <div class="col-xs-3">
 <table class="table table-condensed table-hover">

<tr><td><img alt="" src="resources/images/${product.id}.PNG"><br>

${product.name}<br>
RS. ${product.price}<br>
<a href="${root}/cartadd/${selectedProduct.id}">Add to Cart</a></td></tr></table></div>
</c:forEach>
</div>

	
</body>
</html>

