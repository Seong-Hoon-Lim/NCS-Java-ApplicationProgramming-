
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kudangtang.jv300.mod010.domain.User, java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<jsp:include page="../incl/banner.jsp">
		<jsp:param value="<%=URLEncoder.encode(\"자바빈즈와 JSP\", \"UTF-8\") %>" name="subTitle"/>
	</jsp:include>
	</div>
	<h3>회원가입 되었습니다</h3>
	<jsp:useBean id="user" class="com.kudangtang.jv300.mod010.domain.User" scope="request"/>
	아이디		: <jsp:getProperty property="userId" name="user"/> <br>
	이름		: <jsp:getProperty property="userName" name="user"/> <br>
	생년월일	: <jsp:getProperty property="userBirthDay" name="user"/> <br>
	이메일		: <jsp:getProperty property="userEmail" name="user"/> <br>
	생성일		: <jsp:getProperty property="regDate" name="user"/> <br>
	<%@include file="../incl/copyright.jsp" %>
</body>
</html>