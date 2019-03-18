package com.service;

import java.io.IOException;
import java.sql.SQLException;

import com.bean.Member;
import com.bean.User;
import com.dao.Member_DAO;

public class Login_service {
	private Member_DAO mdao = new Member_DAO();
	
	public com.bean.User login(String id, String pw) throws IOException {
		System.out.println("- Login_service login");
		try {
			User data = new User();
			Member mb = mdao.getMemberId(id);
			if(mb == null) {
				throw new RuntimeException();
			}
			if(!mb.matchPW(pw)) {
				throw new RuntimeException();
			}
			data.setId(id);
			data.setName(mb.getName());
			return data;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
