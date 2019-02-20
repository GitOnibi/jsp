package com.model.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.Handler;

public class LogoutHandler implements Handler {
	@Override
	public String processRequest(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		String msg = "정상적으로 로그아웃 되었습니다";
		request.setAttribute("msg", msg);
		return "index.jsp";
	}
}