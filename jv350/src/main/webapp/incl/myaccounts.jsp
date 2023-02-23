<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="vo.Account"%>
<%@ page import="service.AccountService"%>
<!-- 
1. 세션 id를 이용해서 가진 계좌를 전부 조회한다
2. 나오면 뿌리고 없으면 없네요! 만들까요? 하는 버튼을 띄운다 
 -->

<%
	ArrayList<Account> accs = new ArrayList<Account>();
	AccountService aService = new AccountService();
	
	String myid = (String) session.getAttribute("id");
	System.out.println(myid);
	accs = aService.findmyAccount(myid);
%>

<div id="myaccounts">

	<div>
	
		<% if(myid == null){%>
		<h3>기능을 이용하려면 로그인 해주세요!</h3>
		<% }
		else if (accs.size() == 0) {
		%>
		<h3>계좌가 없네요! 하나 만들까요?</h3>
		<a href="./pages/newAccount.jsp">계좌 생성</a>

		<%
		} else {
		%>
		<h3>내 계좌 확인</h3>
		
		<div id="listwrap">
		<%
		for (int i = 0; i < accs.size(); i++) {
			Account acc = accs.get(i);
		%>
		
		<ul>
			<li>계좌번호 : <%=acc.getAccountNum()%></li>
			<li>잔액 : <%=acc.getBalance()%></li>
			<li>계좌종류 : <%=acc.getAccountType()%></li>				
		</ul>
		<%
		}
		%></div>
		<h3>계좌가 더 필요하다면?</h3>
		<a href="./pages/newAccount.jsp">계좌 생성</a>

		<%
		}
		%>



	</div>

</div>