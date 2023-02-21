<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My 페이지</title>
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
		<h1>My 페이지</h1>			
		<nav>
			<ul>
				<li><a href="update_user.jsp">회원정보수정</a></li>
				<li><a href="index.jsp">로그아웃</a></li>				
				<li><a href="list_users.jsp">회원전체목록</a></li>				
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