<%@page import="java.util.List"%>
<%@page import="com.kudangtang.banking.domain.Customer"%>
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
	
	<table border="1">
		<tr height="50">
			<td width="150" align="center">고객번호</td>
			<td width="150" align="center">이름</td>
			<td width="150" align="center">주민번호</td>
			<td width="200" align="center">휴대전화</td>
			<td width="200" align="center">일반전화</td>
			<td width="200" align="center">아이디</td>
			<td width="200" align="center">비밀번호</td>
			<td width="200" align="center">이메일</td>
		</tr>
		<c:forEach var="customer" items="${userList }">
		<tr height="50">
			<td width="150" align="center">${customer.id}</td>
			<td width="150" align="center">${customer.name}</td>
			<td width="200" align="center">${customer.ssn}</td>
			<td width="200" align="center">${customer.phone}</td>
			<td width="200" align="center">${customer.tel}</td>
			<td width="150" align="center">${customer.userId}</td>
			<td width="200" align="center">${customer.passwd}</td>
			<td width="200" align="center">${customer.email}</td>
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