<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import= "com.techpalle.util.SuccessPage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome User</title>
</head>
<body>

<% SuccessPage sp = (SuccessPage)request.getAttribute("successDetails"); %>
	<header><%=sp.header %></header>
	
	<p><%=sp.p %></p>
	
	<footer><%=sp.footer %></footer>
</body>
</html>