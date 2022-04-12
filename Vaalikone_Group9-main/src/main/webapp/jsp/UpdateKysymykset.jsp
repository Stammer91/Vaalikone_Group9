<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.*" %>
<%@ page import="dao.Dao" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../header.html" %>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>${requestScope.kysymys.id} ${requestScope.kysymys.kysymys}</title>
</head>

<h2>Muokkaa kysymystä</h2>
<form action='updatekysymys' method='post'>

<label for="id">ID</label> <br>
<input type="text" name="id" value="${requestScope.kysymys.id}" readonly> <br><br>

<label for="kysymys">Kysymys</label> <br>
<input type="text" name="kysymys" value="${requestScope.kysymys.kysymys}"> <br><br>



<input type="submit" value="Tallenna">
</form>


<%@ include file="../footer.html" %>