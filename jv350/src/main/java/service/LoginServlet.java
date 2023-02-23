package service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logProc")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.isEmpty() || pw.isEmpty() || "".equals(id.trim()) || "".equals(pw.trim())){
			request.setAttribute("error", "ID 혹은 비밀번호를 입력해 주세요");
			RequestDispatcher rd = request.getRequestDispatcher("../pages/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		
		if(session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id);
			System.out.println("login!");
		}
		else{
			System.out.println("already logged in");
		}
		
		request.setAttribute("id", session.getAttribute("id"));
		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
		rd.forward(request, response);
		response.sendRedirect("/");
	}

}
