<%@page import="java.util.List"%>
<%@page import="com.kudangtang.jv300.mod011.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
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
	<h2>모든 회원보기</h2>
	<%
	ArrayList<User> userList = (ArrayList<User>)request.getAttribute("userList");
		for (int i = 0; i < userList.size(); i++) {
	%>
			<%=userList.get(i) %><br>
	<%
		}
	%>
	<table border="1">
		<tr height="50">
			<td width="150" align="center">아이디</td>
			<td width="150" align="center">이름</td>
			<td width="150" align="center">생년월일</td>
			<td width="200" align="center">이메일</td>
		</tr>
		<c:forEach var="user" items="${userList }">
		<tr height="50">
			<td width="150" align="center">${user.userId}</td>
			<td width="200" align="center">${user.userName}</td>
			<td width="150" align="center">${user.birthDate}</td>
			<td width="200" align="center">${user.email1}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
	<!-- =============================== [footer] ==================================== -->
	<div>
		<%@include file="/incl/copyright.jsp" %>
	</div>
</body>
</html>