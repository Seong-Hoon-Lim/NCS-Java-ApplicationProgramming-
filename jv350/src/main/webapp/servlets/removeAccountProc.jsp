<%@page import="service.AccountService"%>
<%@page import="vo.Account"%>
<%@page import="vo.User"%>
<%@page import="service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	request.setCharacterEncoding("UTF-8");
	Account acc = new Account();
	AccountService aService = new AccountService();
	

	//로그인 된 세션 정보를 가지고 있는지 검증
	String myid = null;
	try {
		myid = (String)session.getAttribute("id");
		if(myid == null || myid.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		else {
			aService.removeAccount(myid);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
%>
<%
	RequestDispatcher rd = request.getRequestDispatcher("../index.jsp");
	rd.forward(request, response);
%>