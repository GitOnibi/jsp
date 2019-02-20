package com.control;

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

@WebServlet("/Control_Servlet")
public class Control_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Handler> handlerMap = new HashMap<String, Handler>();

    public Control_Servlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	Properties prop = new Properties();
    	
    	try( FileReader fr = new FileReader("C:\\users\\105\\eclipse-workspace\\JSPproject05\\WebContent\\WEB-INF\\member.properties") ) {
    		prop.load(fr);
    	} catch(IOException e) {
    		throw new ServletException(e);
    	}
    	
    	Iterator<Object> key = prop.keySet().iterator();
    	
    	while(key.hasNext()) {
    		String cmd			= (String)key.next();
    		String handlerName	= prop.getProperty(cmd);
    		
    		try {
    			Class<?> handlerClass = Class.forName(handlerName);
    			Handler handlerInstance = (Handler)handlerClass.newInstance();
    			handlerMap.put(cmd, handlerInstance);
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
		Handler handler = handlerMap.get(cmd);
		String view = null;
		
		if(handler == null) {
			handler = new NullHandler();
		}
		
		try {
			view = handler.processRequest(request, response);
		} catch(Exception e) {
			throw new ServletException(e);
		}
		
		if(handler != null) {
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
}
