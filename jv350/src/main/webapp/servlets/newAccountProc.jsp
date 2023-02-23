<%@page import="javax.servlet.RequestDispatcher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ page import="service.AccountService" %>
<%@ page import="vo.Account"%>
<%@ page import="vo.SavingAccount"%>
<%@ page import="vo.CheckingAccount"%>
<%@ page import="service.AccountNumberGenerator"%>

<% 
	request.setCharacterEncoding("UTF-8");

	String number = request.getParameter("balance");
	double balance = Double.parseDouble(number);
	
	String accNumber = AccountNumberGenerator.generateAccountNum();
	String accType = request.getParameter("accType");
	AccountService accService = new AccountService();
	
	if(accType.charAt(0) == 'S'){
		Account acc = new SavingAccount();
		acc.setBalance(balance);
		acc.setAccountNum(accNumber);
		acc.setOverdraft(0);
		acc.setAccountType(accType.charAt(0));
		acc.setUserId((String)session.getAttribute("id"));
	
		SavingAccount sAcc = (SavingAccount)acc;
		sAcc.setInterestRate(5.5);
		
		accService.newAccount(sAcc);
	}
	else if(accType.charAt(0) == 'C'){
		Account acc = new CheckingAccount();
		acc.setBalance(balance);
		acc.setAccountNum(accNumber);
		acc.setAccountType(accType.charAt(0));
		acc.setUserId((String)session.getAttribute("id"));
		acc.setInterestRate(1.0);
		
		CheckingAccount cAcc = (CheckingAccount)acc;
		cAcc.setOverdraftProtection(1000000.0);
		
		accService.newAccount(cAcc);
	}
%>

<%
	RequestDispatcher rd = request.getRequestDispatcher("../index.jsp");
	rd.forward(request, response);

%>

