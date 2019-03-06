package com.controller;

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

@WebServlet("/ControllerURI")
public class ControllerURI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Main_Handler> map = new HashMap<String, Main_Handler>();

    public ControllerURI() { super(); }

    public void init(ServletConfig config) throws ServletException {
    	String Iparam = config.getInitParameter("ConfigFile");
    	Properties prop = new Properties(); 
    	try(FileReader fr = new FileReader(Iparam)) {
    		prop.load(fr);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	Iterator<?> key = prop.keySet().iterator();
    	while(key.hasNext()) {
    		String cmd = (String)key.next();
    		String value = (String)prop.getProperty(cmd);
    		try {
    			Class<?> hclass = Class.forName(value);
    			Main_Handler hinst = (Main_Handler)hclass.newInstance();
    			map.put(cmd, hinst);
    		} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
    			System.out.println(e);
    		}
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- ControllerURI doGet");
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- ControllerURI action");
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String str = uri.substring(path.length() + 1);
		System.out.println(str);
		Main_Handler mh = map.get(str);
		String view = null;
		if(mh == null) {
			view = "/index.jsp";
		}
		try {
			view = mh.action(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(view != null) {
			RequestDispatcher dsp = request.getRequestDispatcher(view);
			dsp.forward(request, response);
		}
	}
}