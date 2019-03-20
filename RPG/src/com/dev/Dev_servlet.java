package com.dev;

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

import com.dev.Dev_handler;

@WebServlet("/Dev_servlet")
public class Dev_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Dev_handler> map = new HashMap<>();

    public Dev_servlet() { super(); }
    
    public void init(ServletConfig config) throws ServletException {
    	String iparam = config.getInitParameter("DevConfigFile");
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
    			Dev_handler hinst = (Dev_handler)hclass.newInstance();
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
		System.out.println("- Dev_servlet action");
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String str = uri.substring(path.length() + 1);
		System.out.println(str);
		Dev_handler dh = map.get(str);
		String view = null;
		if(dh == null) {
			view = "/index_dev.jsp";
		}
		try {
			view = dh.action(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
		if(view != null) {
			RequestDispatcher dsp = request.getRequestDispatcher(view);
			dsp.forward(request, response);
		}
	}
}
