<%@page import="javax.servlet.RequestDispatcher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="service.UserService" %>
<%@ page import="vo.User" %>

<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.isEmpty() || pw.isEmpty() || "".equals(id.trim()) || "".equals(pw.trim())){
		request.setAttribute("error", "ID 혹은 비밀번호를 입력해 주세요");
		RequestDispatcher rd = request.getRequestDispatcher("../pages/login.jsp");
		rd.forward(request, response);
		return;
	}
	
%>

<% 
	UserService uService = new UserService();
	User validUser = new User();
	validUser = uService.loginUser(id, pw);
	
	String idforSession = null;
	if(validUser != null){
		idforSession = validUser.getUserId();
	}
%>

<% 
	
	if(session.isNew() || session.getAttribute("id") == null) {
		session.setAttribute("id", id);
		System.out.println("login!");
	}
	else{
		System.out.println("already logged in");
	}
%>

<% 
    response.sendRedirect("../index.jsp");
%>

