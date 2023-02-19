<%@page import="java.net.URLEncoder"%>
<%@ page import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	body{
		position: absolute;
		left: 50%;
		transform: translateX(-50%);             
	}
</style>
<body>
<!-- ===============================[banner]================================= -->
	<div>
	<jsp:include page="../incl/banner.jsp">
		<jsp:param value="<%=URLEncoder.encode(\"EL과 Custom Tags\", \"UTF-8\") %>" name="subTitle"/>
	</jsp:include>
	</div>
<!-- ===============================[Content]================================= -->
	<main>
		<h3>회원가입</h3>
		<c:if test="${not empty errorMsgs}">
			<h4>다음과 같은 에러가 발생하였습니다</h4>
			<ul>
				<c:forEach var="msg" items="${errorMsgs}">
					<li>${msg}</li>
				</c:forEach>
			</ul>
		</c:if>
		<form action="add_user.do" method="post" >
			회원 아이디	: <input type="text" placeholder="아이디 입력" minlength="4" maxlength="20" name="user_id"> <br>
			비밀번호	: <input type="password" placeholder="비밀번호 입력" minlength="4" maxlength="12" name="user_pw"> <br>
			이름		: <input type="text" placeholder="이름 입력" name="user_name"> <br>
			생년월일	: <input type="text" minlength="8" maxlength="8" name="user_birthDate" placeholder="yyyyMMdd"> <br>
			이메일		: <input type="text" name="user_email1"> 
			<select name="user_email2">
				<option value="">이메일 선택</option>
				<option value="@gmail.com">구글</option>
				<option value="@naver.com">네이버</option>
				<option value="@nate.com">네이트</option>
				<option value="@daum.net">다음</option>
			</select> <br>
			<input type="submit" value="확인">
		</form>
	</main>
<!-- ===============================[copyright]================================= -->
	<div>
	<%@ include file="../incl/copyright.jsp" %>
	</div>
</body>
</html>