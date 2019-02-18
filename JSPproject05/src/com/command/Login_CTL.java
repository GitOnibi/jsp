package com.command;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login_CTL")
public class Login_CTL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Handler> HandlerMap = new HashMap();
       
    public Login_CTL() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		Properties prop = new Properties();
		
		try (FileReader fr = new FileReader("C:\\Users\\105\\eclipse-workspace\\JSPproject05\\WebContent\\WEB-INF\\command.properties")){
			prop.load(fr);
		} catch(IOException e) {
			throw new ServletException(e);
		}
		
		Iterator<Object> key = prop.keySet().iterator();
		
		while(key.hasNext()) {
			String cmd		= (String)key.next();
			String hname	= prop.getProperty(cmd);
			
			try {
				Class<?> hclass		= Class.forName(hname);
				Handler hinstance	= (Handler)hclass.newInstance();
				HandlerMap.put(cmd, hinstance);
			} catch(Exception e) {
				throw new ServletException(e);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		Handler hd = HandlerMap.get(cmd);
		String view = null;
		
		if(hd == null) {
			hd = new NullHandler();
		}
		
		try {
			view = hd.process(request, response);
		} catch(Exception e) {
			throw new ServletException(e);
		}
		
		if(view != null) {
			RequestDispatcher dsp = request.getRequestDispatcher(view);
			dsp.forward(request, response);
		}
	}

}
