package com.model.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.Handler;

public class InputHandler implements Handler {
	@Override
	public String processRequest(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		Member_DAO temp = new Member_DAO();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		request.setAttribute("id", id);
		temp.inputMember(request);
		String msg = "다시 로그인 해 주세요";
		request.setAttribute("msg", msg);
		return "index.jsp";
	}
}
