<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='../addVastaus' method='post'>
<input type='number' name='vastaus' value=''>
<input type='submit' name='ok' value='OK'>
</form>
<ol>
<c:forEach var="vastaukset" items="${requestScope.vastauslist }">
	<li>${vastaus} <a href='/rest/VaalikoneService/deleteVastaus/${vastaus.id}'>Delete</a> <a href='../readtoupdateVastaus?id=${vastaus.id}'>Update</a>
</c:forEach>
</ol>
</body>
</html>
