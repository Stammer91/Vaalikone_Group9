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
  <b>${kysymys.kysymys}</b>
  
<form method="post" action="Vastaus" enctype=text/plain>

<table>
<INPUT TYPE="radio" NAME="command" VALUE="1">Täysin eri mieltä<BR>
<INPUT TYPE="radio" NAME="command" VALUE="2">Jokseenkin eri mieltä<BR>
<INPUT TYPE="radio" NAME="command" VALUE="3">Ei samaa tai eri mieltä<BR>
<INPUT TYPE="radio" NAME="command" VALUE="4">Jokseenkin samaa mieltä<BR>
<INPUT TYPE="radio" NAME="command" VALUE="5">Täysin samaa mieltä<BR>
</table>

</div>
</c:forEach>

<%@ include file="../footer.html" %>