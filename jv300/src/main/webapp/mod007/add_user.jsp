<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<jsp:param value="<%=URLEncoder.encode(\"자바빈즈와 JSP\", \"UTF-8\") %>" 
				name="subTitle"/>
		</jsp:include>
	</div>
<!-- =============================== [content] =================================== -->
	<div>
		<h2>회원가입</h2><br>			
			<form action="add_user.do" method="post">
				회원아이디: <input type="text" name="userId" maxlength="20"><br>
				비밀번호: <input type="password" name="passwd" maxlength="12"><br>
				비밀번호 확인: <input type="password" name="passwdcheck" maxlength="12"><br>
				이름: <input type="text" name="userName"><br>
				주민번호: <input type="text" name="ssn1" maxlength="6">-<input type="password" name="ssn2" maxlength="7"><br>
				이메일: <input type="text" name="email1">@
						<select name="email2">
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="daum.net">daum.net</option>
							<option value="nate.com">nate.com</option>
							<option value="nate.com">nate.com</option>
							<option value="insert">직접입력</option>			
						</select><br>
				관심분야: <br>
					<input type="checkbox" name="concerns" value="C">C<br>
					<input type="checkbox" name="concerns" value="C++">C++<br>
					<input type="checkbox" name="concerns" value="Java">Java<br>
					<input type="checkbox" name="concerns" value="Python">Python<br>
					<input type="checkbox" name="concerns" value="JavaScript">JavaScript<br><br>
					
				<input type="submit" value="회원가입">		
				
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