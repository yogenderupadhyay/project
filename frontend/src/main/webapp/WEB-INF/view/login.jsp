<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>index</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/STYLESHEET.css">
</head>
<body>
<div class="center">
<form action="validate" class="form">
<img alt="" src="${pageContext.request.contextPath}/resources/images/login.png" height="100px" width="100px">
<h1>LOGIN HERE</h1>
 User Name:<br>
 <input type="text" name="uname" placeholder="Enter Username" required><br>
  Password:<br>
 <input type="password" name="psw" placeholder="Enter Password" required><br>
 <input type="submit" value="submit" ><br>
 Forget Password :
 <a href="REGISTRATION.html" id="button" >Click Here</a><br>
 SIGN UP? :
<a href="REGISTRATION.html" id="button">Click Here</a>
 
</form>
</div>
</body>
</html>