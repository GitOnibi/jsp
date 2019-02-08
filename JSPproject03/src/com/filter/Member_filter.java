package com.filter;

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

@WebFilter("/Member_filter")
public class Member_filter implements Filter {

    public Member_filter() {
        
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("필터 시작");
		HttpServletRequest req = (HttpServletRequest)request;
		String id = req.getParameter("id");
		if(id == null) {
			RequestDispatcher dsp = request.getRequestDispatcher("index.jsp");
			dsp.forward(request, response);
			System.out.println("id 없음");
		} else {
			chain.doFilter(request, response);
		}
		System.out.println("필터 종료");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
