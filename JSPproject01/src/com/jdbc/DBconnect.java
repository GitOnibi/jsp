package com.jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.Join;
import com.jdbc.Notice;

/**
 * Servlet implementation class DBconnect
 */
@WebServlet("/DBconnect")
public class DBconnect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DBconnect() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String type = request.getParameter("type");
		String path = null;
		if( type.equals("show") ) {
			int num	= Integer.parseInt( request.getParameter("num") );
			
			Notice data = new Notice();
			
			data.setWriter("용지혁");
			data.setTitle("글 제목");
			data.setNum(num);
			
			request.setAttribute("data", data);
			
			path = "ex01_notice_write.jsp";
		}
		if( type.equals("insert") ) {
			Join data = new Join();
			data.insert(request);
			path = "ex01_join_save.jsp";
		}
		
		RequestDispatcher dsp = request.getRequestDispatcher(path);
		dsp.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
