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
		<h3>수정 할 회원 정보 입력</h3><br>				
		<form action="modify_user.do" method="post">
		<table border="1">
			<tr height="50">
			<td width="150" align="center">비밀번호: </td>
			<td width="250"  align="center"><input type="password" name="passwd" maxlength="12">
			</tr>
			<tr height="50">
			<td width="150" align="center"> 비밀번호 확인: </td>
			<td width="250"  align="center"><input type="password" name="passwdcheck" maxlength="12">
			</tr>
			<tr height="50">
			<td width="150" align="center"> 생년월일: </td>
			<td width="250"  align="center"><input type="text" name="birthDate" maxlength="8">
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
			<td width="150" align="center">관심분야: </td>
			<td width="250">
				<input type="checkbox" name="concerns" value="C">C<br>
				<input type="checkbox" name="concerns" value="C++">C++<br>
				<input type="checkbox" name="concerns" value="Java">Java<br>
				<input type="checkbox" name="concerns" value="Python">Python<br>
				<input type="checkbox" name="concerns" value="JavaScript">JavaScript<br><br>
			</tr>
			<tr height="50">
			<td colspan="2" width="150" align="center">	
				<input type="submit" value="회원수정">
			
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