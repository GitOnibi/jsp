package com.member;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/Member_filter")
public class Member_filter implements Filter {
	private String encoding;
	
    public Member_filter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("member filter start");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		String loginCheck = (String)session.getAttribute("loginCheck");
		
		boolean login = false;
		if(loginCheck != null) {
			login = true;
		}
		
		if(login) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("msg", "가입 후 사용할 수 있습니다");
			RequestDispatcher dsp = request.getRequestDispatcher("board.jsp");
			dsp.forward(request, response);
		}
		System.out.println("member filter end");
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
	}

}