package com.kudangtang.jv300.mod010;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kudangtang.jv300.mod010.dao.DataSource;
import com.kudangtang.jv300.mod010.dao.UserDao;
import com.kudangtang.jv300.mod010.domain.User;
import com.kudangtang.jv300.mod010.service.UserService;

@WebServlet("/mod010/list_user.do")
public class ListUsersServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	public void init() {
		ServletContext context = getServletContext();
		DataSource dataSource = (DataSource)context.getAttribute("dataSource");
		userService = new UserService(dataSource);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<User> userList = userService.getUserList();
		request.setAttribute("userList", userList);		
		request.getRequestDispatcher("list_users.jsp").forward(request, response);
		
	}
	
	
}
