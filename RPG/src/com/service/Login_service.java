package com.service;

import java.io.IOException;
import java.sql.SQLException;

import com.bean.Member;
import com.bean.User;
import com.dao.Member_DAO;

public class Login_service {
	Member_DAO mdao = new Member_DAO();
	
	public User login(String id, String pw) throws IOException {
		System.out.println("- Login_service login");
		try {
			User user		= new User();
			Member member	= mdao.getMemberId(id);
			
			if(member == null) {
				throw new RuntimeException();
			}
			
			if(!member.matchPW(pw)) {
				throw new RuntimeException();
			}
			
			user.setId(id);
			user.setName(member.getName());
			
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
