<%@page import="service.AccountService"%>
<%@page import="vo.Account"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 해지 페이지</title>
</head>
<body>
	<%
	ArrayList<Account> accs = new ArrayList<Account>();
	AccountService aService = new AccountService();
	
	String myid = (String) session.getAttribute("id");
	System.out.println(myid);
	accs = aService.findmyAccount(myid);
	%>
	<h3>내 계좌 리스트</h3>
		
	<div id="listwrap">
		<%
		for (int i = 0; i < accs.size(); i++) {
			Account acc = accs.get(i);
		%>
		<form action="../servlets/removeAccountProc.jsp">
			<input type="checkbox" name="accountcheck">
			<input type="submit" value="계좌해지" name="accountremove">
		</form>
		<%
			String msg = (String)request.getAttribute("error");
			if (msg == null) {
				msg="";
		%>
		
		<%
			}
		%>
			<%=msg %>
		
		<ul>
			<li>계좌번호 : <%=acc.getAccountNum()%></li>
			<li>잔액 : <%=acc.getBalance()%></li>
			<li>계좌종류 : <%=acc.getAccountType()%></li>				
		</ul>
		<br>
		<%
		}
		%>
	</div>
	<br>
	
	<button><a href="http://localhost:8080/jv350/index.jsp">홈으로</a></button>
	<button><a href="http://localhost:8080/jv350/pages/accService.jsp">뒤로</a></button>

</body>
</html>