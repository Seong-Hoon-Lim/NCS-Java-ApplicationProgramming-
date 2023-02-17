<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome 페이지</title>
</head>
<body>
	<header>
	<!-- =============================== [banner] ==================================== -->
	<div>
		<jsp:include page="/incl/banner.jsp">
			<jsp:param value="<%=URLEncoder.encode(\"쿠당탕\", \"UTF-8\") %>" 
				name="subTitle"/>
		</jsp:include>
	</div>
		<h1>Welcome 페이지 환영합니다</h1>			
		<nav>
			<ul>
				<li><a href="add_user.jsp">회원가입</a></li>
				<li><a href="login.jsp">로그인</a></li>				
			</ul>
		</nav>
	
	</header>
	<footer>
		<!-- =============================== [footer] ==================================== -->
		<div>
			<%@include file="/incl/copyright.jsp" %>
		</div>
	</footer>
</body>
</html>