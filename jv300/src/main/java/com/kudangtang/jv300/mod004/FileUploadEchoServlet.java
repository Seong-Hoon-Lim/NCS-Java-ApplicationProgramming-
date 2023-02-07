package com.kudangtang.jv300.mod004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod004/file_upload_echo.do")
public class FileUploadEchoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>파일 upload 요청 스트림 살펴보기");
		
		request.setCharacterEncoding("UTF-8");	//한글처리가 가능
		
		Enumeration headers = request.getHeaderNames();
		out.println("<ul>");
		//요소를 가지고 있는지 확인해서 가져올 요소가 없을 때 까지 반복
		while (headers.hasMoreElements()) {
			String headerName = (String)headers.nextElement();
			out.println("<li>" + headerName + "=" + request.getHeader(headerName) + "</li>");
		}
		out.println("<h3>request.getInputStream() 의 내용</h3>");
		InputStreamReader iStreamReader = new InputStreamReader(request.getInputStream());
		BufferedReader br = new BufferedReader(iStreamReader);
		StringBuilder contentBuilder = new StringBuilder();
		for (String line; (line = br.readLine()) != null;) {
			out.println(line + "<br>");
			contentBuilder.append(line);
		}
		
		out.println(contentBuilder.toString());
		
		out.println("</ul>");		
		out.println("</body>");
		out.println("</html>");
		out.close();	
	}
}
