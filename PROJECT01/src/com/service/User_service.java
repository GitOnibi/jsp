package com.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.dao.Member_DAO;
import com.model.Member;

public class User_service {
	Member_DAO mdao = new Member_DAO();
	HttpServletRequest request;
	HttpSession session = request.getSession();
	
	public void login(User_param up) {
		try {
			Member data = mdao.getMemberId(up.getId());
			if(data != null) {
				session.setAttribute("id", up.getId());
				session.setAttribute("name", up.getName());
			} else {
				session.invalidate();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
