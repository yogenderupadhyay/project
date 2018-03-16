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
<%@include file="header.jsp" %>
	<div>
	${welcomeMessage}
	${errorMessage}
	</div>
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