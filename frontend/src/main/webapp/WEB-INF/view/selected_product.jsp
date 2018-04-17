<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<img alt="" src="${selectedProductImage}"> <br>

${selectedProduct.id}
<img alt="" src="resources/images/${selectedProduct.id}.PNG">
product name: ${selectedProduct.name} <br>
price : ${selectedProduct.price} <br>
Description : ${selectedProduct.description} <br>
<a href="cart/add/?id=${selectedProduct.id}">Add to Cart</a>
<c:forEach var="product" items="${products}">
${product.name}
${product.description}
${product.price}
<img alt="" src="resources/images/${product.id}.PNG">
</c:forEach>
</body>
</html>