<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" /><title>JSP Example</title>
</head>

<body>
<h1>JSP Form Example</h1>
The Message for Today is <b><%= request.getParameter("data") %></b>
</body>
</html>