package com.kudangtang.jv300.mod009;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod009/add_context.do")
public class AddContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<String[]> contentList;
	
	ServletContextListener icc = new InitializeCourseContents();	
	//requestScope 을 가져오는 것을 가리킴
	ServletContext context = this.getServletContext();
	RequestDispatcher rd = null;

	@SuppressWarnings("unchecked")
	public void init( ) throws ServletException {
		ServletContext context = getServletContext();
		contentList = (List<String[]>)context.getAttribute("contentList");
		for (String[] contents : contentList) {
			for (int i = 0; i < contents.length; i++) {
				contents[i] = escapeHtml(contents[i]);
				//배열원소가 tap 인 경우
				if (contents[i].length() == 0) {
					contents[i] = "&nbsp;&nbsp;&nbsp;&nbsp;";
				}
			}
		}
	}
//	List<String[]> contentList = (List<String[]>) context.getAttribute("contentList");
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
//		try {
//			is = context.getResourceAsStream("/WEB-INF/classes/course_contents.txt");
//			reader = new BufferedReader(new InputStreamReader(is));
//			String record = null;
//			while ((record = reader.readLine()) != null) {
//				if (contents[i].length() == 0) {
//					contents[i] = "&nbsp;&nbsp;&nbsp;&nbsp;";
//				}
//				String[] fields = record.split("\t");
//				contentList.add(fields);
//				context.setAttribute("contentList", contentList);
//				
//				request.setAttribute("contentList", contentList);	
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		rd = request.getRequestDispatcher("add_content.jsp");
//		rd.forward(request, response);
		
		request.setAttribute("contentList", contentList);
		request.getRequestDispatcher("add_content.jsp")
				.forward(request, response);
				
	}
	
	//JSP 에서 < , > 태그도 출력되도록 하는 메소드
	private String escapeHtml(String line) {
		if (line.length() == 0) {
			return line;
		}
		return line.replace("<", "&lt;").replace(">", "&gt;");
	}

}
