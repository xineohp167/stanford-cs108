<%@page import="jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.math.BigDecimal" %>
<%@ page import="model.ShoppingCart" %>
<%@ page import="model.DataManager" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!
    private String liDecorator(DataManager.Product product, int quantityOf) {
        return "<li> <input type ='number' value='" + quantityOf + "' name='" + product.id + "'>"
                + product.name + ", " + product.price + "</li>";
    }
%>
<%
    BigDecimal total = new BigDecimal(0);
    ShoppingCart cart = (ShoppingCart) session.getAttribute(ShoppingCart.ATTRIBUTE_NAME);
    DataManager dm = (DataManager) application.getAttribute(DataManager.ATTRIBUTE_NAME);
    ArrayList<DataManager.Product> products = dm.getProductsList(cart.getProductIDs());
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>

<h1>Shopping Cart</h1>

<form action="ShoppingCartServlet" method="post">
    <ul>
        <%
        
        
           	
        try{
        	for (DataManager.Product product : products) {
        		System.out.println("product.id" + product.id);
                int quantityOfItems = cart.getQuantityOf(product.id);
                total = total.add(product.price.multiply(new BigDecimal(quantityOfItems)));
                out.print(liDecorator(product, quantityOfItems));
            }
        }catch(Exception e){
        	out.print("no products");
        }
               
            
            
        %>
    </ul>
    Total: $ <%= total %> <input type="submit" value="Update Cart"/>
</form>
<a href="/hw5WebStore">Continue shopping</a>

</body>
</html>