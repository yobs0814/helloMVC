<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 

	<h1>${customer.name}is registered successfully.</h1>

	<ul>
		<li>${customer.id}</li>

		<li>${customer.name}</li>

		<li>${customer.gender}</li>

		<li>${customer.email}</li>

	</ul>
	<p>
		<a href="/helloMVC/index.jsp"> go to home page</a>
	</p>

</body>
</html>