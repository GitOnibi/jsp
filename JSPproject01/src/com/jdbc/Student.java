package com.jdbc;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Student")
public class Student extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Student() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		/*
			Map<String, String> code = new HashMap<String, String>();
			code.put("컴퓨터공학", "c1023");
			code.put("메카트로닉", "m4305");
			code.put("전자과", "e1345");
			code.put("국문과", "k3492");
			code.get(dep_name);
		*/
		
		String dep_name	= request.getParameter("dep_name");
		String stu_name	= request.getParameter("stu_name");
		double score1 	= Float.parseFloat( request.getParameter("score1") );
		double score2 	= Float.parseFloat( request.getParameter("score2") );
		double score3 	= Float.parseFloat( request.getParameter("score3") );
		String content = toString(dep_name,stu_name,score1,score2,score3);
		PrintWriter out = response.getWriter();
		out.println("<html><body>" + content + "</body></html>");
	}
	
	public String toString(String dep_name, String stu_name, double score1, double score2, double score3) {
		String depCode;
		double avg = (score1 + score2 + score3) / 3;
		if( dep_name.equals("컴퓨터공학") ) {
			depCode = "c1023";
		} else if( dep_name.equals("메카트로닉") ) {
			depCode = "m4305";
		} else if( dep_name.equals("전자과") ) {
			depCode = "e1345";
		} else if( dep_name.equals("국문과") ) {
			depCode = "k3492";
		} else {
			depCode = "해당 학과 없음";
		}
		String str = "학과 : " + dep_name + "(" + depCode + ")" + " / 이름 : " + stu_name + " / 평점 : " + avg;
		return str;
	}

}
