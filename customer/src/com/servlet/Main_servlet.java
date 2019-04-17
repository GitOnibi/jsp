package com.servlet;

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

import com.control.Main_handler;

@WebServlet("/Main_servlet")
public class Main_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Main_handler> map = new HashMap<>();

    public Main_servlet() { super(); }
    
    public void init(ServletConfig config) throws ServletException {
    	String iparam = config.getInitParameter("ConfigFile");
    	Properties prop = new Properties(); 
    	try(FileReader fr = new FileReader(iparam)) {
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
    			Main_handler hinst = (Main_handler)hclass.newInstance();
    			map.put(cmd, hinst);
    		} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
    			System.out.println(e);
    		}
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("- Main_servlet action");
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String str = uri.substring(path.length() + 1);
		System.out.println(str);
		Main_handler mh = map.get(str);
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
