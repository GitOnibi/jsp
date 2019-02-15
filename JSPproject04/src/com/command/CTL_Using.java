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

@WebServlet("/CTL_Using")
public class CTL_Using extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Handler> HandlerMap = new HashMap();
       
    public CTL_Using() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		String file = getInitParameter("file");
		Properties prop = new Properties();
		String filepath = getServletContext().getRealPath(file);
		
		try (FileReader fr = new FileReader(filepath)){
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
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		if( cmd.indexOf(request.getContextPath()) == 0) {
			cmd = cmd.substring(request.getContextPath().length());
		}
		Handler hd = HandlerMap.get(cmd);
		if(hd == null) {
			hd = new NullHandler();
		}
		String view = null;
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
