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
<title>${requestScope.ehdokas.etunimi} ${requestScope.ehdokas.sukunimi}</title>
</head>

<h2>Muokkaa ehdokkaan tietoja</h2>
<form action='update' method='post'>

<label for="ehdokas_id">ID</label> <br>
<input type="text" name="ehdokas_id"> <br><br>

<label for="etunimi">Etunimi</label> <br>
<input type="text" name="etunimi" value="${requestScope.ehdokas.etunimi}"> <br><br>

<label for="sukunimi">Sukunimi</label> <br>
<input type="text" name="sukunimi" value="${requestScope.ehdokas.sukunimi}"> <br><br>

<label for="puolue">Puolue</label> <br>
<input type="text" name="puolue" value="${requestScope.ehdokas.puolue}"> <br><br>

<label for="kotipaikkakunta">kotipaikkakunta</label> <br>
<input type="text" name="kotipaikkakunta" value="${requestScope.ehdokas.kotipaikkakunta}"> <br><br>

<label for="Ika">Ikä</label> <br>
<input type="text" name="ika" value="${requestScope.ehdokas.ika}"> <br><br>

<label for="miksi_eduskuntaan">Miksi eduskuntaan?</label> <br>
<input type="text" name="miksi_eduskuntaan" value="${requestScope.ehdokas.miksi_eduskuntaan}" rows="4" cols="50">
<br><br>

<label for="mita_asioita_haluat_edistaa">Mitä asioita haluat edistää?</label> <br>
<input type="text" name="mita_asioita_haluat_edistaa" value="${requestScope.ehdokas.mita_asioita_haluat_edistaa}" rows="4" cols="50">
<br><br>

<label for="ammatti">Ammatti</label> <br>
<input type="text" name="ammatti" value="${requestScope.ehdokas.ammatti}"> <br><br>

<label for="aanestysnumero">Äänestysnumero</label> <br>
<input type="text" name="aanestysnumero" value="${requestScope.ehdokas.aanestysnumero}"> <br><br>

<input type="submit" value="Tallenna">
</form>


<%@ include file="../footer.html" %>