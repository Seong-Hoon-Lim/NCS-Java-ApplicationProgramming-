package com.kudangtang.jv300.mod008;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod008/add_user.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	/**
	 * 싱글턴 패턴
	 */
	private UserService userService;
	
	public void init() {
		userService = new UserService();
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");	//한글처리가 가능
		
		//1. form 파라메터 얻기
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String userName = request.getParameter("userName");
		String ssn1 = request.getParameter("ssn1");
		String ssn2 = request.getParameter("ssn2");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String[] concerns = request.getParameterValues("concerns");
		
		//2. form 데이터 유효성 검증
		List<String> errorMsgs = new ArrayList<>();
		validateEmpy(userId, "userId", errorMsgs);
		validateEmpy(passwd, "passwd", errorMsgs);
		validateEmpy(userName, "userName", errorMsgs);
		validateEmpy(email1, "emali", errorMsgs);
		RequestDispatcher rd = null;
		if (!errorMsgs.isEmpty()) {
			request.setAttribute("errorMsgs", errorMsgs);
			rd = request.getRequestDispatcher("add_user.jsp");
			rd.forward(request, response);
			return;
		}

		User user = new User();
		user.setUserId(userId);
		user.setPasswd(passwd);
		user.setUserName(userName);
		user.setSsn1(ssn1);
		user.setSsn2(ssn2);
		user.setEmail1(email1);
		user.setEmail2(email2);
		user.setConcerns(concerns);
		
		//3. 비즈니스 서비스 호출
		userService.addUser(user);		
		
		//4. Next View 결정
		request.setAttribute("user", user);
//		request.setAttribute("passwdcheck", passwdcheck);
//		request.setAttribute("email2", email2);
		
		rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
		}				
		
	
	private void validateEmpy(String value, String param, List<String> errorMsg) {
		if (value == null || value.length() == 0) {
			errorMsg.add(param + " is required.");
		}
	}
      
}
