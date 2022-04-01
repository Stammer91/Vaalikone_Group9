<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.*" %> 
<%@ page import="dao.dao" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ehdokkaat</title>
</head>


<c:forEach var="ehdokas" items="${requestScope.EhdokasLista}" >
<h2><b>${ehdokas.ehdokas_id}:</b> ${ehdokas.etunimi} ${ehdokas.sukunimi} </h2>
<b>Puolue: </b><br>
${ehdokas.puolue} <br>
<b>Kotipaikkakunta:</b><br>
${ehdokas.kotipaikkakunta}<br>
<b>Ikä: </b><br>
${ehdokas.ika}<br>
<b>Ammatti:</b><br>
${ehdokas.ammatti}<br>
<b>Miksi haluat eduskuntaan?</b><br>
${ehdokas.miksi_eduskuntaan}<br>
<b>Mitä asioita haluat edistää?</b><br>
${ehdokas.mita_asioita_haluat_edistaa}<br>
<br> <br>

</c:forEach>


</html>