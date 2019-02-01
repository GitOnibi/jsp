package com.svt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Info_control")
public class Info_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String company;
	private String notebook;
	private String man;
	
    public Info_control() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		ServletContext sc = config.getServletContext();
		company		= sc.getInitParameter("company");
		notebook	= sc.getInitParameter("notebook");
		man		 	= sc.getInitParameter("man");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		
		String uri	= request.getRequestURI();
		String path	= request.getContextPath();
		String cmd	= uri.substring( path.length() );
		
		if(cmd.equals("/std_v.do")) {
			PoolDAO temp = new PoolDAO();
			List list = new ArrayList();
			list = temp.getStd();
			
			request.setAttribute("list", list);
			RequestDispatcher dsp = request.getRequestDispatcher("std_view.jsp");
			dsp.forward(request, response);
		}
		if(cmd.equals("/std_i.do")) {
			std_DAO temp = new std_DAO();
			temp.setStd(request);
			response.sendRedirect("index.jsp");
		}
		PrintWriter out = response.getWriter();
		out.println("회사명 : " + company + "<br />노트북 : " + notebook + "<br />사람 : " + man);
		/*
		if(cmd.equals("/std_v.do")) {
			std_DAO tmp = new std_DAO();
			List list = new ArrayList();
			list = tmp.getStd();
			
			request.setAttribute("list", list);
			RequestDispatcher dsp = request.getRequestDispatcher("std_view.jsp");
			dsp.forward(request, response);
		}
		if(cmd.equals("/std_i.do")) {
			std_DAO tmp = new std_DAO();
			tmp.setStd(request);
			response.sendRedirect("index.jsp");
		}
		*/
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
