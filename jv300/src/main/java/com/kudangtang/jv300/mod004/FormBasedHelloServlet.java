package com.kudangtang.jv300.mod004;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormBasedHelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String DEFAULT_NAME = "World";
    
    private void generateResponse(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
    	String name = request.getParameter("userName");
    	//name.length() == 0 경우는 WAS 업체에서 null 값을 "" 로 하는 경우가
    	//있으므로 유효성 검증을 진행
    	if (name == null || name.length() == 0) {
    		name = DEFAULT_NAME;
    	}
    	response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
		out.println("<h3>Hello" + name + "</h3>");
		out.println("</body>");
		out.println("</html>");
		out.close();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		generateResponse(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		generateResponse(request, response);
		
	}

}
