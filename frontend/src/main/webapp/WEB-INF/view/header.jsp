<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/STYLESHEET.css"/>" >
</head>
<body class="body">
<div class="header">
		<div class="logo">
			<img src="resources/images/logo.PNG" >
		</div>
	
			<h1>SHOPPING<br>BAZAR</h1>
			
			<ul id="right">
	  			<li><a href="">HOME</a></li> 
	  			<li><a href="">SERVICES</a></li> 
	  			<li><a href="">CONTACT US</a> </li>
	  			<li><a href="">ABOUT US</a></li>
	  			<li id="active"><a href="login">LOGIN</a></li> 
	  			<li id="active"><a href="logout">LOGOUT</a></li> 
			</ul>
</div>
${welcomeMessage}
	${errorMessage}
</body>
</html>