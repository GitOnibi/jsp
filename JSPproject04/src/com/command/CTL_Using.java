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
		Properties prop = new Properties();
		//String file = getInitParameter("file");
		//String filepath = getServletContext().getRealPath(file);
		
		try (FileReader fr = new FileReader("C:\\Users\\105\\eclipse-workspace\\JSPproject04\\WebContent\\WEB-INF\\command.properties")){
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
		String cmd = request.getParameter("cmd");
		Handler hd = HandlerMap.get(cmd); // cmd 를 키 값으로 랜들러를 가져와 넣음
		if(hd == null) { // 값이 없으면 널핸들러를 넣어서 예외처리
			hd = new NullHandler();
		}
		String view = null;
		try { // 오버라이된 추상메서드가 실행
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
