package com.kudangtang.jv300.mod011;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod011/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	public void init() {
		userService = new UserService((DataSource)getServletContext()
				.getAttribute("dataSource11"));
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {		
		
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		System.out.println(userId + ", " + passwd);
		User user = userService.getUser(userId, passwd);	
		RequestDispatcher rd = null;
		
		if (user == null) {
			System.out.println("로그인 실패");
			
			//Next View 결정
			request.setAttribute("user", user);
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
		else
			System.out.println("로그인 성공");
			//Next View 결정
			request.setAttribute("user", user);
			rd = request.getRequestDispatcher("mypage.jsp");
			rd.forward(request, response);
		
	}
	

}
