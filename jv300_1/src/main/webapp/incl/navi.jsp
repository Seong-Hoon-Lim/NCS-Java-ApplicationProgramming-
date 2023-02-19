<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<style>
	*{
		box-sizing: border-box;
	}
	ul{
		margin: 0;
		padding: 0;
	}
	li{
		list-style: none;
		padding: 10px;
	}
	#naviList{
		display: flex;
	}
</style>
<c:if test="${empty user}">
<div id="navi">
	<ul id="naviList">
		<li><a href="../mod011/add_user.jsp">회원가입</a></li>
		<li><a href="../mod011/login.jsp">로그인</a></li>
	</ul>
</div>
</c:if>
<c:if test="${not empty user}">
<div id="navi">
	<ul id="naviList">
		<li><a href="../mod011/my_page.jsp">회원정보수정</a></li>
		<li><a href="../mod011/logout.do">로그아웃</a></li>
		<li><a href="../mod011/list_user.do">회원전체목록</a></li>
	</ul>
</div>
</c:if>