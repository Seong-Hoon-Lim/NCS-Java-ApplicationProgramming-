<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<link rel="stylesheet" href="./css/index.css">
<link rel="stylesheet" href="./css/myaccounts.css">
</head>
<body>
	 <div id="wrap">
	 	<jsp:include page="./incl/banner.jsp"/>
		    
		<div id="main">
			<jsp:include page="./incl/myaccounts.jsp"/>
		</div>
	 	
	 	<jsp:include page="./incl/copyright.jsp"/>	
	 
	 <!-- wrap -->
	 </div>
              

</body>
</html>