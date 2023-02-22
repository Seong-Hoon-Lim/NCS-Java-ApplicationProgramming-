package com.kudangtang.banking.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kudangtang.banking.DataSource;
import com.kudangtang.banking.domain.Customer;
import com.kudangtang.banking.service.CustomerServiceImpl;

@WebServlet("/mod001/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerServiceImpl customerService;
	
	public void init() {
		customerService = new CustomerServiceImpl((DataSource)getServletContext()
				.getAttribute("dataSource"));
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		System.out.println(userId + ", " + passwd);
				
		Customer customer = customerService.getUser(userId);	
		
		/**
		 * 고객정보 일치하지 않을 경우 다시 로그인 페이지로 이동
		 * 고객정보 일치할 경우 세션 가져오기
		 */
		if (customer.getPasswd().equals(userId)) {
			request.setAttribute("notfound", "해당 하는 유저 정보가 없습니다.");
			System.out.println("로그인 실패");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("customer", customer);
			System.out.println();
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
	
		}
	}

}
