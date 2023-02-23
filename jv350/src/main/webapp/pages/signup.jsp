<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/signup.css">
    <title>Sign up</title>
</head>
<body>

    <div id="wrap">
        <div id="dummy">

        </div>
   
    <form action="../servlets/signupProc.jsp" method="post" name="signup">
        <h3>기본 정보 입력</h3> 
        <label for="name">이름</label>
        <input type="text" name="name" id="name" required>
        
        <label for="id">아이디</label>
        <input type="text" name="id" id="id" required><br>
        
        <label for="email">이메일</label>
        <input type="text" name="emailName" id="emailName" required class="email"> @
        <select name="emailSiteSelect" required>
            <option value="naver.com">naver.com</option>
            <option value="gmail.com">gmail.com</option>
            <option value="nate.com">nate.com</option>
            <option value="daum.net">daum.net</option>
        </select><br>
        
        <label for="ssn">주민등록번호</label>
        <input type="text" name="ssnFront" required class="phone"> - <input type="text" name="ssnBack" required class="phone">
        
        <label for="pw">비밀번호</label>
        <input type="password" name="pw" id="pw" required><br>
        
        <label for="pwcheck">비밀번호 재입력</label>
        <input type="password" name="pwcheck" id="pwcheck" required><br>
        
        <label for="phone">휴대전화</label>
        <input type="number" name="pnum1" maxlength="3" required class="phone">
        -<input type="number" name="pnum2" maxlength="4" required class="phone">
        -<input type="number" name="pnum3" maxlength="4" required class="phone"><br>

        <input type="submit" value="회원가입" name="submit" class="btn">
    </form>

</div>
    
    
</body>
</html>