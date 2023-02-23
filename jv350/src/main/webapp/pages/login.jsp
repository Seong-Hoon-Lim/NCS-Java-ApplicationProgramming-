<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="../css/login.css">
<title>Login</title>
</head>
<body>
 <div id="wrap">
        <div id="dummy">

        </div>
        
        <% 
        	String msg = (String)request.getAttribute("error");
        	if(msg == null) msg="";
        %>
        
        <%= msg %> 
    
        <form action="../servlets/loginProc.jsp" method="post" name="login">
            <label for="id">아이디</label>
            <input type="text" name="id" id="id" required><br>
            
            <label for="id">비밀번호</label>
            <input type="password" name="pw" id="pw" required>
            
            <input type="submit" value="submit" name="Login" class="btn"><br>
        </form>

        <div id="etc">
            <a href="#">findID</a>
            <a href="#">findPW</a><br>
            <a href="#">Sign Up</a>
        </div>
    
        
    
    </div>

</body>
</html>