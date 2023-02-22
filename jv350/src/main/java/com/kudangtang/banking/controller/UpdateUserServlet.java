package com.kudangtang.banking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kudangtang.banking.DataSource;
import com.kudangtang.banking.domain.Customer;
import com.kudangtang.banking.service.CustomerServiceImpl;

@WebServlet("/mod001/update_user.do")
public class UpdateUserServlet extends HttpServlet {
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
			String phone = request.getParameter("phone");
			String tel = request.getParameter("tel");
			String passwd = request.getParameter("passwd");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String email = email1 + "@" + email2;
			
			//유효성 검증
			HttpSession session = request.getSession();
			Customer customer = (Customer)session.getAttribute("customer");
			customer.setName(validateEqual(name, customer.getName(), customer));
			customer.setPhone(validateEqual(phone, customer.getPhone(), customer));
			customer.setTel(validateEqual(tel, customer.getTel(), customer));
			customer.setPasswd(validateEqual(passwd, customer.getPasswd(), customer));
			customer.setEmail(validateEqual(email, customer.getEmail(), customer));
						
			//비즈니스 서비스 호출
			customerService.updateUser(customer);
						
	}			
	
	public static String validateEqual(String value, String param, Customer customer) {
		String result = value;
		if (value == null || value.length() == 0) {
			value = param;			
		}
		return result;
	}
			
}
