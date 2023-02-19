package com.kudangtang.jv300.mod011.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kudangtang.jv300.mod011.domain.User;
import com.kudangtang.jv300.mod011.service.UserService;
import com.kudangtang.jv300.mod011.service.UserServiceImpl;

@WebServlet("/mod011/list_user.do")
public class ListUserServlet extends HttpServlet{
	UserService us = null;
	
	@Override
	public void init() throws ServletException {
		us = UserServiceImpl.getUserService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> userList = us.findUserList();
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("list_user.jsp").forward(req, resp);
	}
}
