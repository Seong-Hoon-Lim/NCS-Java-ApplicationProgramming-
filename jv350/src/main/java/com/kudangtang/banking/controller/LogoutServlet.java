package com.kudangtang.banking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mod001/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		
		HttpSession session = request.getSession();
		session.invalidate();	//세션 무효화
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
}
