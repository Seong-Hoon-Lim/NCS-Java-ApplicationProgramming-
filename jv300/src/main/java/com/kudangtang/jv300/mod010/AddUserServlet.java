package com.kudangtang.jv300.mod010;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kudangtang.jv300.mod010.dao.DataSource;
import com.kudangtang.jv300.mod010.service.UserService;

@WebServlet("/mod010/add_user.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	public void init() {
		userService = new UserService((DataSource)getServletContext()
				.getAttribute("dataSource"));
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//폼 파라메타 얻기
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("userId");
		String userName = request.getParameter("userId");
		String birthDate = request.getParameter("userId");
		String email1 = request.getParameter("userId");
		String email2 = request.getParameter("userId");
		String email = email1 + "@" + email2;
		String[] concerns = request.getParameterValues("concerns");
		
		//폼데이터 유효성검증
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
		
		
	}
	
	private void validateEmpy(String value, String param, List<String> errorMsg) {
		if (value == null || value.length() == 0) {
			errorMsg.add(param + " is required.");
		}
	}
      
}
