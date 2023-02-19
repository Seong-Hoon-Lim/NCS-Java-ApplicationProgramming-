<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	table{
		border-collapse: collapse;
	}
	tr, th, td {
		border : 1px solid black;
	}
</style>
<body>
	<table>
		<tr>
			<th>회원 아이디</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>이메일</th>
			<th>생성일</th>
		</tr>
		<c:forEach var="user" items="${userList}">
			<tr>
				<td>
					${user.userId}
				</td>
				<td>
					${user.userName}
				</td>
				<td>
					${user.userBirthDay}
				</td>
				<td>
					${user.userEmail}
				</td>
				<td>
					${user.regDate}
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>