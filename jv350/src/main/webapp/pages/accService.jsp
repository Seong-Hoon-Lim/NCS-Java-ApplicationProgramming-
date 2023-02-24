<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="vo.Account"%>
<%@ page import="service.AccountService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/index.css">
<link rel="stylesheet" href="../css/accService.css">
</head>
<body>
<%
	ArrayList<Account> accs = new ArrayList<Account>();
	AccountService aService = new AccountService();
	
	String myid = (String) session.getAttribute("id");
	System.out.println(myid);
	accs = aService.findmyAccount(myid);
	
%>

 <div id="wrap">
 	<jsp:include page="../incl/banner.jsp"/>
 	
 	<div id="main">
 		<div >
		<%
			for (int i = 0; i < accs.size(); i++) {
				Account acc = accs.get(i);
			%>
			<div id="listwrap">
				<ul>
					<li>계좌번호 : <%=acc.getAccountNum()%></li>
					<li>잔액 : <%=acc.getBalance()%></li>
					<li>계좌종류 : <%=acc.getAccountType()%></li>
				</ul> 
				
				<form method="post" name="accService">
					<input type="text" value="<%=acc.getAccountNum()%>" name="accNum" id="textInput">
					<input type="submit" formaction="./depositForm.jsp" value="입금" name="deposit" class="btn">
					<input type="submit" formaction="./withdrawForm.jsp" value="출금" name="withdraw" class="btn">
					<input type="submit" formaction="./transferForm.jsp" value="송금" name="transfer" class="btn">
					<input type="submit" formaction="removeaccount.jsp" value="계좌삭제" name="delete" class="btn">
				</form>
				
			</div>
		<%
		}
		%></div>
 	

	</div>
 	

 	
 	<jsp:include page="../incl/copyright.jsp"/>	
 
 </div>

</body>
</html>