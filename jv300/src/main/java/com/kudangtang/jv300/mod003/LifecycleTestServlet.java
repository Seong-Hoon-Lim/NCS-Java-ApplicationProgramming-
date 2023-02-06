package com.kudangtang.jv300.mod003;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LifecycleTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LifecycleTestServlet() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() method is called.");
	}
	
	public void destroy() {
		System.out.println("destory() method is called.");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet(service)() method is called.");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
		out.println("<h3> Servlet Lifecycle Test</h3>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
