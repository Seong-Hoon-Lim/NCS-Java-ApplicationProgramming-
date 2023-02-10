<%@page import="java.net.URLEncoder"%>
<%@page import="com.kudangtang.jv300.mod007.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<jsp:param value="<%=URLEncoder.encode(\"자바빈즈와 JSP\", \"UTF-8\") %>" 
				name="subTitle"/>
		</jsp:include>
	</div>
<!-- =============================== [content] =================================== -->
	<div>
	<h3>회원 가입되었습니다.</h3>
	<jsp:useBean id="user" 
				 class="com.kudangtang.jv300.mod007.User" 
				 scope="request"/>
	아이디 : <jsp:getProperty property="userId" name="user"/><br>
	이름 : <jsp:getProperty property="userName" name="user"/><br>
	</div>
	<br>
	<hr>
<!-- =============================== [footer] ==================================== -->
	<div>
		<%@include file="/incl/copyright.jsp" %>
	</div>
</body>
</html>