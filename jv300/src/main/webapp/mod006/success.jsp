<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String userId = (String)request.getAttribute("userId");
	String passwd = (String)request.getAttribute("passwd");
	String passwdcheck = (String)request.getAttribute("passwdcheck");
	String userName = (String)request.getAttribute("userName");
	String ssn1 = (String)request.getAttribute("ssn1");
	String ssn2 = (String)request.getAttribute("ssn2");
	String email1 = (String)request.getAttribute("email1");
	String email2 = (String)request.getAttribute("email2");
	String[] concerns = (String[])request.getParameterValues("concerns");
%>

	<h3>회원 가입되었습니다.</h3>
	아이디 : <%=userId %><br>
	패스워드 : <%=passwd %><br>
	이름 : <%=userName %><br>
	주민번호 : <%=ssn1 %>-<%=ssn2 %><br>
	이메일 : <%=email1 %>@<%=email2 %><br>
	관심분야 :
	<ul>
		<%
			for (String concern : concerns) {
		%>
		<li><%=concern %></li>
		<%
			}
		%>
	</ul>
</body>
</html>