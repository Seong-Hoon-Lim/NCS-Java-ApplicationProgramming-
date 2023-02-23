<%@page import="java.util.ArrayList"%>
<%@page import="vo.Account"%>
<%@page import="service.AccountService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="service.UserService" %>
<%@ page import="vo.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link rel="stylesheet" href="../css/index.css">
<link rel="stylesheet" href="../css/mypage.css">
</head>
<body>

<%
	UserService userv = new UserService();
	User me = new User();
	
	String myid = (String)session.getAttribute("id");
	me = userv.myPage(myid);
	
%>

<%
	ArrayList<Account> accs = new ArrayList<Account>();
	AccountService aService = new AccountService();
		
	myid = (String) session.getAttribute("id");
	System.out.println(myid);
	accs = aService.findmyAccount(myid);
%>

 <div id="wrap">
	 	<jsp:include page="../incl/banner.jsp"/>
		    
			<div id="me">
				<h3>내 정보 확인</h3>				
				<table>
					<tr>
						<td>이름</td>
						<td><%= me.getName() %></td>
					</tr>
					<tr>
						<td>아이디</td>
						<td><%= me.getUserId() %></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><%= me.getPhone() %></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><%= me.getEmail() %></td>
					</tr>				
				</table>				
				<input type="submit" value="modify" class="btns"> 
			
			</div>
			 	
	 	<jsp:include page="../incl/copyright.jsp"/>	
	 
	 <!-- wrap -->
	 </div>
	
	
	

</body>
</html>