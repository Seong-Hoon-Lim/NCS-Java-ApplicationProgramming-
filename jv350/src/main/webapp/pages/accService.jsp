<%@page import="java.util.ArrayList"%>
<%@page import="service.AccountService"%>
<%@page import="vo.Account"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�������� ������</title>
</head>
<body>
	<form action="../servlets/removeAccountProc.jsp">
		<input type="submit" value="���»���" name="accountremove">
	</form>	
	
</body>
</html>