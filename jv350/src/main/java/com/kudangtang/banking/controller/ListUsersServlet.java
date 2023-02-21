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
	
	private CustomerServiceImpl customerServiceImpl;
	
	public void init() {
		ServletContext context = getServletContext();
		DataSource dataSource = (DataSource)context.getAttribute("dataSource");
		customerServiceImpl = new CustomerServiceImpl(dataSource);
		customerServiceImpl = (CustomerServiceImpl) CustomerServiceImpl.getCustomerService();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//비즈니스 서비스 호출
		List<Customer> userList = (ArrayList<Customer>)customerServiceImpl.getAllCustomers();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("list_users.jsp").forward(request, response);
		
	}
		
}
