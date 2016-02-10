<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.DataManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Store</title>
</head>
<body>

<h1>Student Store</h1>

<p>Items available:</p>

<%!
public String liDecorator(String id, String name){
	return "<li><a href=\"show-product.jsp?id=" + id + "\">" + name + "</a></li>";
}
%>

<ul>
    <%
        DataManager dm = (DataManager) application.getAttribute(DataManager.ATTRIBUTE_NAME);
        for(DataManager.Product p: dm.getProductsList())
            out.print(liDecorator(p.id, p.name));
    %>

</ul>

</body>
</html>