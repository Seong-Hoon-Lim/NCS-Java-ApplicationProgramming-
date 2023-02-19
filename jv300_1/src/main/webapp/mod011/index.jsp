<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../incl/banner.jsp">
		<jsp:param value="<%=URLEncoder.encode(\"메인페이지\", \"UTF-8\") %>" name="subTitle"/>
	</jsp:include>
	<jsp:include page="../incl/navi.jsp">
		<jsp:param value="${user}" name="user"/>
	</jsp:include>
	
	
	
	<%@ include file="../incl/copyright.jsp" %>
</body>
</html>