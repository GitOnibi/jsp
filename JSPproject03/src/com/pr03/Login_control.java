package com.pr03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pr03.Member_DAO;

@WebServlet("/Login_control")
public class Login_control extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login_control() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri	= request.getRequestURI();
		String path	= request.getContextPath();
		String cmd	= uri.substring( path.length() );
		HttpSession session = request.getSession();
		
		if(cmd.equals("/Login_check.do")) {
			Member_DAO temp = new Member_DAO();
			if( temp.getMember(request) ) {
				session.setAttribute("id", temp.getId(request));
			} else {
				session.invalidate();
			}
		}
		if(cmd.equals("/Login_signin.do")) {
			Member_DAO temp = new Member_DAO();
			temp.setMember(request);
			response.sendRedirect("index.jsp");
		}
		if(cmd.equals("/Login_logout.do")) {
			session.invalidate();
		}
		RequestDispatcher dsp = request.getRequestDispatcher("index.jsp");
		dsp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
