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
<title>Muokkaa ehdokkaita</title>
</head>

<h2>Muokkaa ehdokkaita</h2>
<form action='Edit' method='post'>
<label for="ehdokas_id">ID</label> <br>
<input type="text" id="ehdokas_id" name="ehdokas_id"> <br><br>
<label for="etunimi">Etunimi</label> <br>
<input type="text" id="etunimi" name="etunimi"> <br><br>
<label for="sukunimi">Sukunimi</label> <br>
<input type="text" id="sukunimi" name="sukunimi"> <br><br>
<label for="puolue">Puolue</label> <br>
<input type="text" id="puolue" name="puolue"> <br><br>
<label for="kotipaikkakunta">kotipaikkakunta</label> <br>
<input type="text" id="kotipaikkakunta" name="kotipaikkakunta"> <br><br>
<label for="Ika">Ikä</label> <br>
<input type="text" id="ika" name="ika"> <br><br>
<label for="miksi_eduskuntaan">Miksi eduskuntaan?</label> <br>
<textarea id="miksi_eduskuntaan" name="miksi_eduskuntaan" rows="5" cols="50">
</textarea> <br><br>
<label for="mita_asioita_haluat_edistaa">Mitä asioita haluat edistää?</label> <br>
<textarea id="mita_asioita_haluat_edistaa" name="mita_asioita_haluat_edistaa" rows="5" cols="50">
</textarea> <br><br>
<label for="ammatti">Ammatti</label> <br>
<input type="text" id="ammatti" name="ammatti"> <br><br>

<h1>Käytössä olevat äänestysnumerot</h1>
<c:forEach var="ehdokas" items="${requestScope.EhdokasLista}" >

<ul>
  <li><b>${ehdokas.aanestysnumero}</b></li>
</ul>
 
</c:forEach>

<label for="aanestysnumero">Äänestysnumero</label> <br>
<input type="text" id="aanestysnumero" name="aanestysnumero"> <br><br>
<input type="submit" value="Tallenna">
</form>


<%@ include file="../footer.html" %>