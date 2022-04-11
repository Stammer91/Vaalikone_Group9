<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.*" %>
<%@ page import="dao.Dao" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../header.html" %>

<c:forEach var="ehdokas" items="${requestScope.EhdokasLista}">
<div class="card">
  <h1>${ehdokas.etunimi} ${ehdokas.sukunimi} &nbsp;N:o ${ehdokas.aanestysnumero}</h1>
  
  <a href='/readtoupdate?aanestysnumero=${ehdokas.aanestysnumero}'>Muokkaa ehdokkaan tietoja</a>
  <a href='/Delete?aanestysnumero=${ehdokas.aanestysnumero}'>Poista ehdokas</a>
</div>
</c:forEach>

<%@ include file="../footer.html" %>