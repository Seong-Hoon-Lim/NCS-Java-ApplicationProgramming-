package com.kudangtang.jv300.mod004;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/mod004/file_upload.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 2,
		maxFileSize = 1024 * 1024 * 10,
		maxRequestSize = 1024 * 1024 * 50)
public class FileUploadServlet extends HttpServlet {
		
		private static final long serialVersionUID = 1L;
		private static final String SAVE_DIR = "C:/Temp";

		public void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			File fileSaveDir = new File(SAVE_DIR);	
			//컴포지트 패턴 (프로그래밍 언어에서는 파일과 디렉토리를 같게 취급함)
			
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			
			for (Part part : request.getParts()) {
				if (part.getHeader("Content-Disposition").contains("filename=")) {
					part.write(fileSaveDir.getPath() + File.separator + extractFileName(part));		
					//File.separator OS 관계 없이 경로 구분하도록 하는 것
				}
				else {
					System.out.println(getParaneterValue(part));
				}
			}
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h3>Upload has been done successfully</h3>");
			out.println("</body>");
			out.println("</html>");
			out.close();		
			
		}
		
		public String getParaneterValue(Part part) throws IOException {
			InputStreamReader ir = new InputStreamReader(part.getInputStream(), "UTF-8");
			BufferedReader br = new BufferedReader(ir);
			StringBuilder builder = new StringBuilder();
			for (String line; (line = br.readLine()) != null;) {
				builder.append(line);
			}
			return builder.toString();
		}
		//해당 경로에서부터 파일의 이름을 추출해내는 메소드
		private String extractFileName(Part part) {
			String contentDisp = part.getHeader("Content-Disposition");
			for (String s : contentDisp.split(";")) {
				if (s.trim().startsWith("filename")) {
					//공백 문자를 제거
					if (s.contains(File.separator)) {
						return s.substring(s.lastIndexOf(File.separator) + 1).replace("\"", "");
					}
					else {
						return s.substring("filename=".length() + 1).replace("\"", "");
					}
				}
				
			}
			return "";
		}

}
