<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.*" %>
<%@ page import="dao.Dao" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../header.html" %>

<form action="/rest/vaalikoneservice/addvastaus" method="post">
<select name="ehdokasvalinta" id="ehdokasvalinta">
<c:forEach var="ehdokas" items="${requestScope.EhdokasLista}" >
<option value="${ehdokas.aanestysnumero}">${ehdokas.etunimi} ${ehdokas.sukunimi}</option>
</c:forEach>
</select>
<br><br>

<c:forEach var="kysymys" items="${requestScope.KysymysLista}" >
<b>${kysymys.id} "${kysymys.kysymys}"</b><br>
<table>
<input type="radio" id="r1" name="valinta${kysymys.id}" value="1">
<label for="r1">Täysin eri mieltä</label>
<input type="radio" id="r2" name="valinta${kysymys.id}" value="2">
<label for="r2">Jokseenkin eri mieltä</label>
<input type="radio" id="r3" name="valinta${kysymys.id}" value="3">
<label for="r3">Ei samaa tai eri mieltä</label>
<input type="radio" id="r4" name="valinta${kysymys.id}" value="4">
<label for="r4">Jokseenkin samaa mieltä</label>
<input type="radio" id="r5" name="valinta${kysymys.id}" value="5">
<label for="r5">Täysin samaa mieltä</label>
</table>
<br>
</c:forEach>
<br><br>
<input type="submit" id="postvastaus" name="submitvastaus" value="Lähetä vastaukset"> 
</form>

<br><br>
<c:forEach var="vastaus" items="${requestScope.VastausLista}" >
<b>${vastaus.id}</b>: <b>${vastaus.ehdokas}</b>, <b>Vastaus:</b>"${vastaus.vastaus}" <a href='/rest/vaalikoneservice/deletevastaus/${vastaus.id}'>Poista vastaus<br><br></a>
</c:forEach>

<%@ include file="../footer.html" %>