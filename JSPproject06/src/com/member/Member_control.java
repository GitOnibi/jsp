package com.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Member_control")
public class Member_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Member_control() { super(); }

    public void init(ServletConfig config) throws ServletException {}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("login")) {
			System.out.println(cmd);
			Member_DAO temp = new Member_DAO();
			if(temp.getMember(request)) {
				session.setAttribute("id", id);
				session.setAttribute("loged", "true");
			}
		}
		
		if(cmd.equals("logout")) {
			System.out.println(cmd);
			session.invalidate();
		}
		
		RequestDispatcher dsp = request.getRequestDispatcher("index.jsp");
		dsp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
