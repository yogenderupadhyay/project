<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <spring:url var="images" value="/resources/images" />
    <c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="${root}/buy"> BUY</a>  <br>
<c:forEach var="cart" items="${cartList}">
<img alt="" src=" ${ImagesFolder}${cart.productID}.PNG">
Name  : <input type="text" name="price" value="${cart.productName}"> <br>
price : <input type="text" name="price" value="${cart.price}"> <br>
quantity  : <input type="text" name="price" value="${cart.quantity}"> <br>
</c:forEach>
</body>
</html>