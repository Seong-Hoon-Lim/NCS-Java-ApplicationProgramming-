<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login 페이지</title>
</head>
<body>
<!-- =============================== [banner] ==================================== -->
	<div>
		<jsp:include page="/incl/banner.jsp">
			<jsp:param value="<%=URLEncoder.encode(\"쿠당탕\", \"UTF-8\") %>" 
				name="subTitle"/>
		</jsp:include>
	</div>
	<h3>로그인</h3>
	<form action="login.do" method="post">
		<label>아이디 </label><input type="text" name="userId"/><br>
		<label>패스워드 </label><input type="password" name="passwd" value="Spring12"/><br>
		<br>
		<input type="submit" value="로그인"/>
	</form>
<!-- =============================== [footer] ==================================== -->
<div>
	<%@include file="/incl/copyright.jsp" %>
</div>
</body>
</html>