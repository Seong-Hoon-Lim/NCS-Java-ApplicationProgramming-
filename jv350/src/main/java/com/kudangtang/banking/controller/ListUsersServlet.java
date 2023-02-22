package com.kudangtang.banking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kudangtang.banking.DataSource;
import com.kudangtang.banking.domain.Customer;
import com.kudangtang.banking.service.CustomerServiceImpl;

@WebServlet("/mod001/list_user.do")
public class ListUsersServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private CustomerServiceImpl customerService;
	
	public void init() {
		customerService = new CustomerServiceImpl((DataSource)getServletContext()
				.getAttribute("dataSource"));
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//비즈니스 서비스 호출
		List<Customer> userList = (ArrayList<Customer>)customerService.getAllCustomers();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("list_users.jsp").forward(request, response);
		
	}
		
}
