<%@page import="java.util.ArrayList"%>
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
	ArrayList<Account> accs = new ArrayList<>();
	

	//로그인 된 세션 정보를 가지고 있는지 검증
	String myid = null;
	String accNumber = "";
	try {
		myid = (String)session.getAttribute("id");
		accs = aService.findmyAccount(myid);
		if(myid == null || myid.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		else {
			for (int i = 0; i < accs.size(); i++) {
				acc = accs.get(i);	//계좌 리스트
				
				//체크된 계좌 파라미터
				String item = request.getParameter("accountremove");				
					//체크된 파라티터가 null 아니고 잔액이 0원 미만이면 계좌 해지
					if (item != null) {	
						if (acc.getBalance() <= 0.0) {
						aService.removeAccount(myid);
						System.out.println(item);
						}											
						else {
							request.setAttribute("error", "잔고가 남아있습니다. 잔고를 비워주세요.");
							RequestDispatcher rd = request.getRequestDispatcher("../pages/removeaccount.jsp");
							rd.forward(request, response);
							return;
						}
					}
				}
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