package com.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Member_CTL")
public class Member_CTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Member_CTL() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = request.getSession();
		if( cmd.equals("login") ) {
			if(!id.equals("") || id != null || !pw.equals("") || pw != null) {
				session.setAttribute("id", id);
				session.setAttribute("loginCheck", "true");
			}
		}
		if( cmd.equals("logout") ) {
			session.invalidate();
		}
		RequestDispatcher dsp = request.getRequestDispatcher("index.jsp");
		dsp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}