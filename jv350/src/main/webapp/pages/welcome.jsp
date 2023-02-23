<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/welcome.css">
    <title>Welcome</title>
</head>
<body>
    <div id="wrap">
        <div id="dummy">

        </div>
		
		<% 
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		%>
        <div id="others">
            <h3>회원가입이 완료되었습니다.</h3>
            <p><%= name %>님의 회원가입을 축하합니다. <br> 안전하고 실속있는 서비스로 찾아뵙겠습니다. </p>

            <div id="btns">
                <button><a href="../index.jsp">홈으로</a></button>
                <button><a href="../pages/login.jsp">로그인</a></button>
            </div>
           
        </div>
    
    
    </div>
</body>
</html>