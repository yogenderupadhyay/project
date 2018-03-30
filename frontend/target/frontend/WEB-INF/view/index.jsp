<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>index</title>
<link rel="stylesheet" type="text/css" href="/resources/css/STYLESHEET.css" >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<%@include file="header.jsp" %>
<c:if test="${(errorMessage!=null)}">
       <i class="fa fa-frown-o" style="font-size:48px;color:red">${errorMessage}</i><br>
       <jsp:include page="login.jsp"></jsp:include>
  </c:if>
<c:if test="${isAdmin==true}">
	<jsp:include page="admin/adminhome.jsp"></jsp:include>

	</c:if>
	<div>
	<c:if test="${isUserClickedLogin==true}">
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedRegister==true}">
	<jsp:include page="registration.jsp"></jsp:include>
		<%@ include file="registration.jsp" %>
	</c:if>	
	</div>
</body>
</html>