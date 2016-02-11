<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.DataManager" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    DataManager dm = (DataManager) application.getAttribute(DataManager.ATTRIBUTE_NAME);
    DataManager.Product product =  dm.getProductInfo(request.getParameter("id"));
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=product.name%></title>
</head>
<body>

<h1><%= product.name %></h1>
<img src="<%="images/"+product.img%>" alt="<%="images/"+product.img%>">


<form action="ShoppingCartServlet" method="post">
    $<%=product.price%> <input name="productID" type="hidden" value="<%= product.id %>"/>
    <input type="submit" value="Add to cart"/>
</form>

</body>
</html>