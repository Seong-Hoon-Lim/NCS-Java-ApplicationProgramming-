<%@page import="java.net.URLEncoder"%>
<%@page import="com.kudangtang.jv300.mod011.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>success 페이지</title>
</head>
<body>
<!-- =============================== [banner] ==================================== -->
	<div>
		<jsp:include page="/incl/banner.jsp">
			<jsp:param value="<%=URLEncoder.encode(\"쿠당탕\", \"UTF-8\") %>" 
				name="subTitle"/>
		</jsp:include>
	</div>
<!-- =============================== [content] =================================== -->
	<div>
	<h3>회원정보가 수정되었습니다.</h3>
	<jsp:useBean id="user" 
				 class="com.kudangtang.jv300.mod011.User" 
				 scope="request"/>
	아이디 : <jsp:getProperty property="userId" name="user"/><br>
	이름 : <jsp:getProperty property="userName" name="user"/><br>
	</div>
	<br>
	<a href="mypage.jsp">홈으로이동</a>
	<hr>
<!-- =============================== [footer] ==================================== -->
	<div>
		<%@include file="/incl/copyright.jsp" %>
	</div>
</body>
</html>