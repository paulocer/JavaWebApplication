<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="header.jsp"%>
<body>
<h1 style="padding: 50px; text-align: center;"><%="Olá "+session.getAttribute("user") %></h1>
<h2 style="padding: 50px; text-align: center;">Bem-vido a implementação do exercício 01 da Residência UFBA</h2>

</body>
<%@ include file="footer.jsp"%>
</html>