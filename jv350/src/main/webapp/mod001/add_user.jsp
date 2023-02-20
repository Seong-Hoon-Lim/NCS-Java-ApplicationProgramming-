<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
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
		<h3>회원 정보 입력</h3><br>
		<c:if test="${not empty errorMsgs}">
			<h4>다음과 같은 에러가 발생하였습니다.</h4>
			<ul>
				<c:forEach var="errorMsg" items="${requestScope.errorMsgs}">
					<li>${errorMsg}</li>		
				</c:forEach>		
			</ul>
		</c:if>		
				
		<form action="add_user.do" method="post">
		<table border="1">
			<tr height="50">
			<td width="150" align="center">이름: </td>
			<td width="250"  align="center"><input type="text" name="name" maxlength="20">
			</tr>
			<tr height="50">
			<td width="150" align="center">주민번호: </td>
			<td width="250"  align="center"><input type="password" name="ssn" maxlength="13">
			</tr>
			<tr height="50">
			<td width="150" align="center">휴대전화번호: </td>
			<td width="250"  align="center"><input type="text" name="phone" maxlength="11">
			</tr>
			<tr height="50">
			<td width="150" align="center">전화번호: </td>
			<td width="250"  align="center"><input type="text" name="tel" maxlength="11">
			</tr>
			<tr height="50">
			<td width="150" align="center">회원아이디: </td>
			<td width="250"  align="center"><input type="text" name="userId" maxlength="20">
			</tr>
			<tr height="50">
			<td width="150" align="center">비밀번호: </td>
			<td width="250"  align="center"><input type="password" name="passwd" maxlength="12">
			</tr>
			<tr height="50">
			<td width="150" align="center"> 비밀번호 확인: </td>
			<td width="250"  align="center"><input type="password" name="passwdcheck" maxlength="12">
			</tr>
			<tr height="50">
				<td width="150" align="center">이메일: </td>
				<td width="250"  align="center"><input type="text" name="email1">@
					<select name="email2">
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="daum.net">daum.net</option>
						<option value="nate.com">nate.com</option>
						<option value="nate.com">nate.com</option>
						<option value="insert">직접입력</option>			
					</select>
			</tr>	
			<tr height="50">
			<td colspan="2" width="150" align="center">	
				<input type="submit" value="회원가입">				
		</table>				
		</form>
	</div>
	<br>
	<hr>
<!-- =============================== [footer] ==================================== -->
	<div>
		<%@include file="/incl/copyright.jsp" %>
	</div>
</body>
</html>