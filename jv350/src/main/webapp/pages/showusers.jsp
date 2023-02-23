<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="service.UserService" %>
<%@ page import="vo.User" %>
<%@page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/index.css">
<link rel="stylesheet" href="../css/showusers.css">
<title>ShowuserPage</title>
</head>
<body>
<%
	UserService userv = new UserService();
	ArrayList<User> userList = new ArrayList<>();
	userList = userv.userListSearch();
%>

<div id="wrap">
 	<jsp:include page="../incl/banner.jsp"/>
	
	<div id="me">
		<h3>전체 유저 조회</h3>
		<table>
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>전화번호</th>
				<th>이메일</th>
			</tr>
			
			
		<% 
			for(int i = 0; i<userList.size(); i++){
				User user = new User();
				user = userList.get(i);%>
				<tr>
						<td><%= user.getName() %></td>
						<td><%= user.getUserId() %></td>
						<td><%= user.getPhone() %></td>
						<td><%= user.getEmail() %></td>
				</tr>
				<% 
			}
		%>
			
		</table>
		
	</div>
	
 	<jsp:include page="../incl/copyright.jsp"/>	
 
 <!-- wrap -->
 </div>

	
	
	
	

</body>
</html>