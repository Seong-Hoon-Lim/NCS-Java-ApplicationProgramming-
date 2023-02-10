package com.kudangtang.jv300.mod007;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod007/add_user.do")
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
		String passwdcheck = request.getParameter("passwdcheck");
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
//		else if (passwd == null || passwd.length() == 0) {
//			String msg_pw = "패스워드는 필수 입력 정보입니다.";
//			request.setAttribute("msg_pw", msg_pw);
//			rd = request.getRequestDispatcher("errorPage/error_pw.jsp");
//			rd.forward(request, response);
//			return;
//		}
//			
//		else if (!(passwdcheck.equals(passwd))) {
//			String msg_pwcheck = "입력한 패스워드가 일치하지 않습니다";
//			request.setAttribute("msg_pwcheck", msg_pwcheck);
//			rd = request.getRequestDispatcher("errorPage/error_pwcheck.jsp");
//			rd.forward(request, response);
//			return;
//		}
//		else if (userName == null || userName.length() == 0) {
//			String msg_name = "이름은 필수 입력 정보입니다.";
//			request.setAttribute("msg_name", msg_name);
//			rd = request.getRequestDispatcher("errorPage/error_name.jsp");
//			rd.forward(request, response);
//			return;
//		}
//		else if (ssn1 == null || ssn1.length() < 6) {
//			String msg_ssn1 = "주민등록번호 앞 생년월일을 6자리 숫자를 입력해주세요";
//			request.setAttribute("msg_ssn1", msg_ssn1);
//			rd = request.getRequestDispatcher("errorPage/error_ssn1.jsp");
//			rd.forward(request, response);
//			return;
//		}
//		else if (ssn2 == null || ssn2.length() < 7) {
//			String msg_ssn2 = "주민등록번호 뒤 7자리 숫자를 입력해주세요";
//			request.setAttribute("msg_ssn2", msg_ssn2);
//			rd = request.getRequestDispatcher("errorPage/error_ssn2.jsp");
//			rd.forward(request, response);
//			return;
//		}
//		else if (email1 == null || email1.length() == 0) {
//			String msg_email1 = "이메일 ID는 필수 입력 정보입니다.";
//			request.setAttribute("msg_email1", msg_email1);
//			rd = request.getRequestDispatcher("errorPage/error_email.jsp");
//			rd.forward(request, response);
//			return;
//		}
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
