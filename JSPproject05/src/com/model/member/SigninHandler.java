package com.model.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.Handler;

public class SigninHandler implements Handler {
	@Override
	public String processRequest(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String msg = null;
		
		Member_DAO temp = new Member_DAO();
		
		if(temp.checkMember(id)) {
			msg = "이미 사용중인 아이디 입니다";
			request.setAttribute("msg", msg);
			return "signin.jsp";
		} 
		
		if(id == null || id.equals("") || pw == null || pw.equals("")) {
			msg = "적확히 입력하여 주세요";
			request.setAttribute("msg", msg);
			return "signin.jsp";
		}
		
		temp.setMember(request);
		msg = "정상적으로 가입되었습니다. 다시 로그인 해주세요";
		request.setAttribute("msg", msg);
		return "index.jsp";
	}
}