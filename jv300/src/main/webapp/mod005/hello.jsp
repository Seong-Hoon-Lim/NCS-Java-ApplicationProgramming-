<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 멤버 변수를 선언할 때 <%! 선언문을 사용 --%>
<%! private static final String DEFAULT_NAME="World"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello World</title>
</head>

<%-- Determine the specified name or user default name --%>
<%
	String name = request.getParameter("userName");		//request 는 내장객체
	if ((name == null) || (name.length() == 0)) {
		name = DEFAULT_NAME;
	}
%>
<body>
	<h3> Hello, <%=name %> </h3>
	
</body>
</html>