<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.*" %>
<%@ page import="dao.Dao" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../header.html" %>


<form method="post" action="AddKysymykset">
<label for="kysymys_id">Kysymyksen numero</label> <br>
<input type="text" name="kysymys_id"> <br><br>
<label for="etunimi">Kysymys</label> <br>
<input type="text" name="kysymys"> <br><br>

<input type="submit" value="Tallenna">
</form>


<%@ include file="../footer.html" %>