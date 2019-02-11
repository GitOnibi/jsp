package com.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/Member_filter")
public class Member_filter implements Filter {
	
	private String encoding;

    public Member_filter() {
        
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("필터 시작");
		if(cmdCheck(request, response)) {
			RequestDispatcher dsp = request.getRequestDispatcher("index.jsp");
			dsp.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
		System.out.println("필터 종료");
	}
	
	public boolean cmdCheck(ServletRequest request, ServletResponse response) {
		HttpServletRequest req = (HttpServletRequest)request;
		String cmd = req.getParameter("cmd");
		HttpSession session = req.getSession();
		
		if(req.getCharacterEncoding() == null) {
			try {
				req.setCharacterEncoding(encoding);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if(cmd != null) {
			if(!cmd.equals("logout")) {
				String id = req.getParameter("id");
				String pw = req.getParameter("pw");
				
				if(id.equals("") || id == null || pw.equals("") || pw == null) {
					request.setAttribute("str", "<h2>아이디 또는 패스워드가 올바르지 않습니다.</h2>");
					return true;
				}
				/* 로그인시 가능한 페이지로 집적 접근하였을 경우
				if(session == null || session.equals("")) {
					req.setAttribute("str", "<h2>로그인 실패</h2>");
					return true;
				}
				
				if(session.getAttribute("id") == null) {
					req.setAttribute("str", "<h2>로그인 안됨</h2>");
					return true;
				}
				*/
			}
		}
		return false;
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
	}

}
