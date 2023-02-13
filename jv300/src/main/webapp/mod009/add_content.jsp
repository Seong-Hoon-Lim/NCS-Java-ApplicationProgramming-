<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- =============================== [banner] ==================================== -->
	<div>
		<jsp:include page="/incl/banner.jsp">
			<jsp:param value="<%=URLEncoder.encode(\"ServletContextListener와 Application Scope\", \"UTF-8\") %>" 
				name="subTitle"/>
		</jsp:include>
	</div>
<!-- =============================== [content] =================================== -->
	<div>
		<ul>
			<!-- String[]로 받아와서 데이터 나열 -->
			<c:forEach var="content" items="${contentList}">
				<!-- String[] 에서 문자열 반복 추출 -->
				<c:forEach var="str" items="${content}">
					${str}
				</c:forEach>
				<br>
			</c:forEach>
		</ul>		
	</div>
	<br>
	<hr>
<!-- =============================== [footer] ==================================== -->
	<div>
		<%@include file="/incl/copyright.jsp" %>
	</div>
</body>
</html>