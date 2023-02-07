package com.kudangtang.jv300.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/mod004/add_user.view")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	private void generateResponse(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");	//한글처리가 가능
		
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String userName = request.getParameter("userName");
		String ssn1 = request.getParameter("ssn1");
		String ssn2 = request.getParameter("ssn2");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String[] concerns = request.getParameterValues("concerns");
		
		String pageTitle = "Welcome";
		
		if (userName == null || userName.length() == 0) {
			
		}				
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>" + pageTitle + "</title></head>");
		out.println("<body>");
		out.println("<p>Hello " + userName + "</p>");
		out.println("<p>Your userId is " + userId + "</p>");
		out.println("<p>Your Passwd is " + passwd + "</p>");
		out.println("<p>Your email is " + ssn1 + "-" + ssn2 + "</p>");
		out.println("<p>Your email is " + email1 + "@" + email2 + "</p>");
		out.println("<p>Your concerns</p>");
		out.println("<ul>");
		for (String concern : concerns) {
			out.println("<li>" + concern + "</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		out.close();		
	}
       
    public AddUserServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		generateResponse(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		generateResponse(request, response);

	}

}
