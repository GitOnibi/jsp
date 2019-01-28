package com.jdbc;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

// get post 를 받아주기 위한 클래스들
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mem_control")
public class mem_control extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public mem_control() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int num1, num2, result;
		String op;
		
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		op = request.getParameter("op");
		result = calc(num1, num2, op);
		String str	= "<html>"
					+ "<body>"
					+ "계산결과 : " + num1 + " " + op + " " + " " + num2 + " = " + result
					+ "</body>"
					+ "</html>";
		out.println(str);
		//request.setAttribute("myName", "RYU");
		//RequestDispatcher dsp = request.getRequestDispatcher("servlet_test.jsp");
		//dsp.forward(request, response);
	}
	
	public int calc(int a, int b, String op) {
		int result = 0;
		if( op.equals("+") ) {
			result = a + b;
		} else if( op.equals("-") ) {
			result = a - b;
		} else if( op.equals("*") ) {
			result = a * b;
		} else if( op.equals("/") ) {
			result =  a / b;
		}
		return result;
	}

}
