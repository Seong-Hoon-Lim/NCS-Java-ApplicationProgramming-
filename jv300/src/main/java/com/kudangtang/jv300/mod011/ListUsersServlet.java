package com.kudangtang.jv300.mod011;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod011/list_user.do")
public class ListUsersServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	public void init() {
		ServletContext context = getServletContext();
		DataSource dataSource = (DataSource)context.getAttribute("dataSource11");
		userService = new UserService(dataSource);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//비즈니스 서비스 호출
		List<User> userList = (ArrayList<User>)userService.getUserList();
		request.setAttribute("list", userList);
		request.getRequestDispatcher("list_users.jsp").forward(request, response);
		
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
		}
	}
		
}
