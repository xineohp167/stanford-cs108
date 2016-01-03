<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
<%!
String getComment(java.util.Date date) {
	String comment = "";

	switch(date.getMonth()) {
	case 0: case 1:
		comment = "very cold"; break;
	case 2: case 3: case 4:
		comment = "getting warmer"; break;
	case 5: case 6: case 7:
		comment = "summer!"; break;
	case 8:
		comment = "school time"; break;
	case 9:
		comment = "getting colder"; break;
	case 10:
		comment = "Thanksgiving"; break;
	case 11:
		comment = "break time"; break;
	};

	return comment;
}
%>

<%
java.util.Date now = new java.util.Date();
out.println("It is " + getComment(now));
%>

</body>
</html>