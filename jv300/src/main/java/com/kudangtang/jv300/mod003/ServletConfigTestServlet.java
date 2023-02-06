package com.kudangtang.jv300.mod003;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigTestServlet
 */
public class ServletConfigTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_SEASONS = "Spring, Summer, Autumn, Winter";
	private String[] seasons;
    
	public void init(ServletConfig config) {
		String season_list = config.getInitParameter("season-list");	//Spring,Summer,Fall,Winter
		/* 
		 * 인자가 없는 public void init() 경우에는
		String season_list = getInitParameter("season-list");
		로 사용이 가능하다. 
		*/
		if (season_list == null) {
			season_list = DEFAULT_SEASONS;
		}
		seasons = season_list.split(",");	//"," 단위로 문자열을 잘라낸다
	}

    public ServletConfigTestServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
		out.println("<h3> Servlet Lifecycle Test</h3>");
		out.println("<ul>");		
		for (String season : seasons) {
			out.println("<li>" + season + "</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

}
