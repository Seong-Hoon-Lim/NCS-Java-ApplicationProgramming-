<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.Account" %>
<%@ page import="service.AccountService" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/index.css">
<title>new Account</title>
</head>
<body>

<div id="wrap">
 	<jsp:include page="../incl/banner.jsp"/>
 		<form action="../servlets/newAccountProc.jsp" method="post" name="newacc">
 			<select name="accType" required>
 				<option value="S">저축계좌</option>
 				<option value="C">마이너스계좌</option>
 			</select><br>
 			
 			<label for="balance" >초기 금액</label>
 			<input type="number" name="balance" required>
 			<br>
 			<input type="submit" value="생성" name="submit" class="btn">
 		</form>
 	
 	
 	
 	<jsp:include page="../incl/copyright.jsp"/>	
 
 </div>

</body>
</html>