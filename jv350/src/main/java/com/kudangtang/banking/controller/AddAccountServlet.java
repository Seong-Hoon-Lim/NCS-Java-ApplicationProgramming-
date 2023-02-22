package com.kudangtang.banking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kudangtang.banking.DataSource;
import com.kudangtang.banking.service.AccountServiceImpl;

public class AddAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountServiceImpl accountService;
	
	public void init() {
		accountService = new AccountServiceImpl((DataSource)getServletContext()
				.getAttribute("dataSource"));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			
			//폼 파라미터 얻기
			String balance = request.getParameter("balance");
			String interestRate = request.getParameter("interestRate");
			String overdraft = request.getParameter("overdraft");
						
	}

}
