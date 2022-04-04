<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.*" %>
<%@ page import="dao.Dao" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    

<c:forEach var="ehdokas" items="${requestScope.EhdokasLista}" >
<div class="card">
  <h1>${ehdokas.etunimi} ${ehdokas.sukunimi}</h1>
  <b><u>Puolue</u></b>
  <p>${ehdokas.puolue}</p>
  <b><u>Kotipaikkakunta</u></b>
  <p>${ehdokas.kotipaikkakunta}</p>
  <b><u>Ammatti</u></b>
  <p>${ehdokas.ammatti}</p>
  <b><u>Miksi haluat eduskuntaan?</u></b>
  <p>${ehdokas.miksi_eduskuntaan}</p>
  <b><u>Mitä asioita haluat edistää?</u></b>
  <p>${ehdokas.mita_asioita_haluat_edistaa}</p>
</div>
</c:forEach>