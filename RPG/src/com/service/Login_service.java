package com.service;

import java.io.IOException;
import java.sql.SQLException;

import com.bean.Member;
import com.bean.User;
import com.dao.Member_DAO;

public class Login_service {
	private Member_DAO mdao = new Member_DAO();
	public User login(String user_id, String user_pw) throws IOException {
		System.out.println("- Login_service login");
		try {
			User data = new User();
			Member mb = mdao.getMemberId(user_id);
			if(mb == null) throw new RuntimeException();
			if(!mb.match_pw(user_pw)) throw new RuntimeException();
			data.setUser_id(user_id);
			data.setUser_email(mb.getUser_email());
			return data;
		} catch(SQLException e) { throw new RuntimeException(e); }
	}
}
