package com.pr03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		if(cmd.equals("/Login_check.do")) {
			Member_DAO temp = new Member_DAO();
			if( temp.getMember(request) ) {
				request.setAttribute("id", temp.getId(request));
				RequestDispatcher dsp = request.getRequestDispatcher("index.jsp");
				dsp.forward(request, response);
			} else {
				request.setAttribute("id", null);
				RequestDispatcher dsp = request.getRequestDispatcher("index.jsp");
				dsp.forward(request, response);
			}
		}
		if(cmd.equals("/Login_signIn.do")) {
			Member_DAO temp = new Member_DAO();
			temp.setMember(request);
			response.sendRedirect("index.jsp");
		}
		if(cmd.equals("/Login_out.do")) {
			request.setAttribute("id", null);
			RequestDispatcher dsp = request.getRequestDispatcher("index.jsp");
			dsp.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
