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

@WebServlet("/mod011/update.do")
public class UpdateServlet extends HttpServlet {
	UserServiceImpl userService;
	@Override
	public void init() throws ServletException {
		userService = UserServiceImpl.getUserService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String passwd = req.getParameter("password");
		String userName = req.getParameter("userName");
		String email1 = req.getParameter("email1");
		String email2 = req.getParameter("email2");
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		user.setUserPw(userTest(passwd, user.getUserPw(), user));
		user.setUserName(userTest(userName, user.getUserName(), user));
		user.setUserEmail(userTest(email1 + email2, user.getUserEmail(), user));
		
		
		userService.updateUser(user);
	}
	private static String userTest(String value, String type, User user) {
		String userValue = value;
		if(value == null || value.length() == 0) {
			userValue = type;
		}
		return userValue;
	}
}
