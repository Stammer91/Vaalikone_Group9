<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.*" %>
<%@ page import="dao.Dao" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../header.html" %>

<c:forEach var="kysymys" items="${requestScope.KysymysLista}">
<div class="card">
  
  <b>${kysymys.id}</b>
  <p>${kysymys.kysymys}</p>
  <a href='/readtoupdatekysymys?kysymys_id=${kysymys.id}'>Muokkaa kysymystä</a>
  <a href='/DeleteKysymys?kysymys_id=${kysymys.id}'>Poista kysymys</a>
  
</div>
</c:forEach>

<%@ include file="../footer.html" %>