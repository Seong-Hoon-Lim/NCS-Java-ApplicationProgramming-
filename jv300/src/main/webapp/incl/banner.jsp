<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	<h3><%=URLDecoder.decode(request.getParameter("subTitle"), "UTF-8") %></h3>
</div>