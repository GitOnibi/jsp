package com.svt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {"/InitParam"}, 
		initParams = {
			@WebInitParam(name = "title", value="소호강호"),
			@WebInitParam(name = "writer", value="김용"),
			@WebInitParam(name = "year", value="1900"),
		}
		)
public class InitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String title;
	private String writer;
	private String year;
	
    public InitParam() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		title	= config.getInitParameter("title");
		writer	= config.getInitParameter("writer");
		year	= config.getInitParameter("year");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("제목 : " + title + "<br />저자 : " + writer + "<br />발간 : " + year);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
