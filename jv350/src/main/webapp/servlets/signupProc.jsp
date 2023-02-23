<%@page import="javax.servlet.RequestDispatcher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ page import="service.UserService" %>
<%@ page import="vo.User" %>

<% 
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	
	String emailId = request.getParameter("emailName");
	String emailWeb = request.getParameter("emailSiteSelect");
	String email = emailId + "@" + emailWeb;
	
	String pnum1 = request.getParameter("pnum1");
	String pnum2 = request.getParameter("pnum2");
	String pnum3 = request.getParameter("pnum3");
	String phone = pnum1 +  pnum2 +  pnum3;
	
	String ssnFront = request.getParameter("ssnFront");
	String ssnBack = request.getParameter("ssnBack");
	String ssn = ssnFront + "-" + ssnBack;
	
	User user = new User();
	user.setUserId(id);
	user.setPasswd(pw);
	user.setName(name);
	user.setEmail(email);
	user.setPhone(phone);
	user.setSsn(ssn);
	
	
%>

<%
	UserService uService = new UserService();
	uService.signupUser(user);
	
	request.setAttribute("name", name);
	
	RequestDispatcher rd = request.getRequestDispatcher("../pages/welcome.jsp");
	rd.forward(request, response);

%>


