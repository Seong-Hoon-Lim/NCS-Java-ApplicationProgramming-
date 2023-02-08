package com.kudangtang.jv300.mod006;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod006/add_user.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
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
		
		//2. request scope 에 저장
		request.setAttribute("userId", userId);
		request.setAttribute("passwd", passwd);
		request.setAttribute("userName", userName);
		request.setAttribute("ssn1", ssn1);
		request.setAttribute("ssn2", ssn2);
		request.setAttribute("email1", email1);
		request.setAttribute("email2", email2);
		request.setAttribute("concerns", concerns);
		
		//3. JSP로 forward		
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		rd.forward(request, response);
				
		
	}
      
}
