<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.*" %>
<%@ page import="dao.Dao" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../header.html" %>

<form action="/rest/VaalikoneService/addvastaus" method="post">
<c:forEach var="ehdokas" items="${requestScope.EhdokasLista}" >
<option value="${ehdokas.aanestysnumero}">${ehdokas.sukunimi} ${ehdokas.etunimi}</option>
</c:forEach>
<br><br>

<c:forEach var="kysymys" items="${requestScope.KysymysLista}" >
<li><b>${kysymys.id} "${kysymys.kysymys}"</b><br>
<input type="radio" id="r1" name="valinta1${kysymys.id}" value="1">
<label for="r1">Täysin eri mieltä</label>
<input type="radio" id="r2" name="valinta2${kysymys.id}" value="2">
<label for="r2">Jokseenkin eri mieltä</label>
<input type="radio" id="r3" name="valinta3${kysymys.id}" value="3">
<label for="r3">Ei samaa tai eri mieltä</label>
<input type="radio" id="r4" name="valinta4${kysymys.id}" value="4">
<label for="r4">Jokseenkin samaa mieltä</label>
<input type="radio" id="r5" name="valinta5${kysymys.id}" value="5">
<label for="r5">Täysin samaa mieltä</label><br>
<br>
</c:forEach>
<br><br>
<input type="submit" id="postvastaus" name="submitvastaus" value="Vastaus"> 
</form>

<ol>
<c:forEach var="vastaus" items="${requestScope.VastausLista}" >
<li><b>ID:</b>${vastaus.id}, "${vastaus.vastaus}" <a href='/rest/VaalikoneService/deleteanswer/${vastaus.id}'>Poista vastaus</a>
</c:forEach>
</ol>

<form action="/rest/VaalikoneService/sendvastaus" method="post">
<c:forEach var="ehdokas" items="${requestScope.EhdokasLista}" >
<option value="${ehdokas.aanestysnumero}">${ehdokas.sukunimi} ${ehokas.etunimi}</option>
</c:forEach>
<input type="submit" value="Valitse ehdokas">  
</form>

<%@ include file="../footer.html" %>