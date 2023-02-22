package com.kudangtang.banking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kudangtang.banking.DataSource;
import com.kudangtang.banking.domain.Customer;
import com.kudangtang.banking.service.CustomerServiceImpl;

@WebServlet("/mod001/add_user.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerServiceImpl customerService;
	
	public void init() {
		customerService = new CustomerServiceImpl((DataSource)getServletContext()
				.getAttribute("dataSource"));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			
			//폼 파라미터 얻기
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String phone = request.getParameter("phone");
			String tel = request.getParameter("tel");
			String userId = request.getParameter("userId");
			String passwd = request.getParameter("passwd");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String email = email1 + "@" + email2;
//			String regDate = request.getParameter("regDate");
			
			//폼데이터 유효성 검증
			List<String> errorMsgs = new ArrayList<>();
			validateEmpy(name, "name", errorMsgs);
			validateEmpy(ssn, "ssn", errorMsgs);
			validateEmpy(phone, "phone", errorMsgs);
			validateEmpy(userId, "userId", errorMsgs);
			validateEmpy(passwd, "passwd", errorMsgs);
			validateEmpy(email, "email", errorMsgs);
			RequestDispatcher rd = null;
			if (!errorMsgs.isEmpty()) {
				request.setAttribute("errorMsgs", errorMsgs);
				rd = request.getRequestDispatcher("add_user.jsp");
				rd.forward(request, response);
				return;
			}
			Customer customer = new Customer();
			customer.setName(name);
			customer.setSsn(ssn);
			customer.setPhone(phone);
			customer.setTel(tel);
			customer.setUserId(userId);
			customer.setPasswd(passwd);
			customer.setEmail(email);
//			customer.setRegDate(regDate);
			
			//비즈니스 서비스 호출
			customerService.addCustomer(customer);
			
			//Next View 결정
			request.setAttribute("customer", customer);
			rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);				
				
	}
	
	/**
	 * 데이터 비어있는지 여부 검증 하는 메소드
	 * @param value
	 * @param param
	 * @param errorMsg
	 */
	private void validateEmpy(String value, String param, List<String> errorMsg) {
		if (value == null || value.length() == 0) {
			errorMsg.add(param + " is required.");
		}
	}
}
