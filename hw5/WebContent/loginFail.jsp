<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Information Incorrect</title>
</head>
<body>
<h1>Please Try Again</h1>

<p> Your user name or password are incorrect. Please try again</p>

<form action="LoginServlet" method="post">
    User Name: <input type="text" name="name"/> <br/>
    Password: <input type="password" name="password"/>
    <input type="submit" value="login"/>
</form>
<a href="createNewAccount.jsp">Create New Account</a>
</body>
</html>