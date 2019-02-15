package com.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Handler;

public class BoardHandler implements Handler {
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("part", "게시판입니다");
		return "/board.jsp";
	}
}
