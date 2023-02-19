package com.kudangtang.jv300.mod011.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kudangtang.jv300.mod011.domain.User;
import com.kudangtang.jv300.mod011.service.UserServiceImpl;


@WebServlet("/mod011/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -5613276865827241233L;
	private UserServiceImpl userService;
	
	public void init() {
		userService = UserServiceImpl.getUserService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String passwd = req.getParameter("passwd");
		
		User user = userService.findUser(userId, passwd);
		
		if(user == null) {
			req.setAttribute("notuser", "정보를 찾을 수 없습니다");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
