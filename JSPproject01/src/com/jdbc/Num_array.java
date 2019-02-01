package com.jdbc;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Num_array")
public class Num_array extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Num_array() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		Random rand = new Random();
		
		int[] ranArray = new int[10];
		
		for(int i = 0; i < ranArray.length; i++) {
			ranArray[i] = rand.nextInt(100) + 1;
		}
		
		int cnt = 0;
		
		for(int i = 0; i < ranArray.length; i++) {
			if(ranArray[i] % 2 != 0) {
				ranArray[i] = rand.nextInt(100) + 1;
				i -= 1;
				cnt += 1;
			}
		}
		
		out.print("배열의 모든 수가 짝수 입니다.");
		request.setAttribute("ranArray", ranArray);
		request.setAttribute("cnt", cnt);
		RequestDispatcher dsp = request.getRequestDispatcher("view1.jsp");
		dsp.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
