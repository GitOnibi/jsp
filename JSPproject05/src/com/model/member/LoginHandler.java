package com.model.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.Handler;

public class LoginHandler implements Handler {
	@Override
	public String processRequest(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException {
		Member_DAO temp = new Member_DAO();
		String id = request.getParameter("id");
		String msg = null;
		
		if(temp.getMember(request)) {
			HttpSession session = request.getSession();
			List<Member_bean> list = new ArrayList<Member_bean>();
			list = temp.getInfo(request);
			session.setAttribute("id", id);
			session.setAttribute("list", list);
			return "member.jsp";
		} else {
			msg = "아이디 또는 패스워드가 잘못 입력 되었습니다";
			request.setAttribute("msg", msg);
			return "index.jsp";
		}
	}
}