<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h3>내정보</h3>
	아이디 	: ${user.userId} <br>
	비밀번호 	: ${user.userPw} <br>
	닉네임 	: ${user.userName} <br>
	생일		: ${user.userBirthDay} <br>
	이메일 	: ${user.userEmail} <br>
	생성일 	: ${user.regDate}
	
	<form action="update.do" method="post">
		<input type="password" placeholder="바꿀 비밀번호" name="password"> <br>
		<input type="text" placeholder="바꿀 닉네임" name="userName">	<br>	
		<input type="text" placeholder="바꿀 이메일" name="email1">
		<select name="email2">
			<option value="">직접입력</option>
			<option value="@google.com">구글</option>
			<option value="@naver.com">네이버</option>
			<option value="@nate.com">네이트</option>
			<option value="@daum.net">다음</option>
		</select> <br>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>