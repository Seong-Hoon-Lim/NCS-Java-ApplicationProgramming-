<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>다음과 같은 에러가 발생하였습니다.</h3>
	<ul>
	<%
		List<String> errorMsgs = (List<String>)request.getAttribute("errorMsgs");
		for (String errorMsg : errorMsgs) {
	%>
	<li><%=errorMsg %></li><br>
	<%
		}
	%>
	</ul>
</body>
</html>