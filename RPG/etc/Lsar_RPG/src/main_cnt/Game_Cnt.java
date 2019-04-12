package main_cnt;

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

import member.avatar_model;


/**
 * Servlet implementation class Game_Cnt
 */
@WebServlet("/Game_Cnt")
public class Game_Cnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private  Map<String, main_hnd> map = new HashMap<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game_Cnt() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
			String Iparam=config.getInitParameter("ConfigFile");
			
			Properties prop = new Properties();
		try(FileReader fs = new FileReader(Iparam)){
			prop.load(fs);
		}catch(IOException e) {
			
		}
		Iterator key = prop.keySet().iterator();
		while(key.hasNext()) {
			String cmd = (String)key.next();
			String value = prop.getProperty(cmd);
			try {
				Class<?> hclass = Class.forName(value);
				main_hnd hinst=(main_hnd)hclass.newInstance();
				map.put(cmd, hinst);
			}catch(ClassNotFoundException | InstantiationException |IllegalAccessException e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		action(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		action(request, response);
	}
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String cd = uri.substring(path.length()+1);
		main_hnd hd = map.get(cd);
		System.out.println(cd);
		System.out.println("game_cnt");
		String view =null;
		
		if(hd==null)
			view="/lsar.jsp";
		try {
			view=hd.action(request, response);
		}catch(Exception e) {
			System.out.println("game_cnt"+e);
		}
		if(view!=null) {
			
			RequestDispatcher dsp = request.getRequestDispatcher(view);
			dsp.forward(request, response);
		}
	}
}
