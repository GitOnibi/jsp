package com.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Main_CTL")
public class Main_CTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Main_CTL() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri	= request.getRequestURI();
		String path	= request.getContextPath();
		String cmd	= uri.substring( path.length() );
		String view = "index.jsp";
		
		if(cmd.equals("board")) {
			view = "/member/board.jsp";
			request.setAttribute("msg", "게시판입니다");
		}
		if(cmd.equals("reference")) {
			view = "/member/reference.jsp";
			request.setAttribute("msg", "자료실입니다");
		}
		if(cmd.equals("service")) {
			view = "/member/service.jsp";
			request.setAttribute("msg", "고객센터입니다");
		}
		RequestDispatcher dsp = request.getRequestDispatcher(view);
		dsp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}