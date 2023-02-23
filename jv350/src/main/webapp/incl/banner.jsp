<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>

	<div id="navWrap">
   <!--wrap �ȿ� ���� �� -->
    <div id="logo">
        <h3>HAPPY</h3>
        <h3>BANK</h3>
    </div>
    	<%
    		if(session.isNew() || session.getAttribute("id") == null){%>
    			<ul>
	    		<li><a href="http://localhost:8080/jv350/pages/showusers.jsp">전체 사용자 조회</a></li>
	    		<li><a href="http://localhost:8080/jv350/pages/login.jsp">다른 기능은 로그인 후 사용 가능합니다</a></li>
	    		<li><a href="http://localhost:8080/jv350/pages/signup.jsp">회원가입</a></li>
	    	</ul>
    		<% }
    	
    		else{%>
    			<ul>
		        <li><a href="http://localhost:8080/jv350/pages/showusers.jsp">전체 사용자 조회</a></li>
		        <li><a href="http://localhost:8080/jv350/pages/accService.jsp">금융 서비스</a></li>
		        <li><a href="http://localhost:8080/jv350/pages/mypage.jsp">마이페이지</a></li>
    		</ul>
    		<% }
    	
    	%>
	     
    <button><a href="http://localhost:8080/jv350/index.jsp">HOME</a></button>
</div>

	<%
	if(session.isNew() || session.getAttribute("id") == null){%>
		<button class="log"><a href="http://localhost:8080/jv350/pages/login.jsp">로그인</a></button>
	<% }
    	
    		else{%>
    		<button class="log"><a href="http://localhost:8080/jv350/servlets/logoutProc.jsp">로그아웃</a></button>
		<% }
    	
    	%>
   