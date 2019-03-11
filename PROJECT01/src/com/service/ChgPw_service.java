package com.service;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.Member_DAO;
import com.model.Member;

public class ChgPw_service {
	private Member_DAO mdao = new Member_DAO();
	
	public void changePassword(String id, String pw, String npw) {
		try {
			Member data = mdao.getMemberId(id);
			if(data == null) {
				throw new RuntimeException();
			}
			if(!data.matchPW(pw)) {
				throw new RuntimeException("notmatch");
			}
			data.chg_password(npw);
			mdao.update_pw(data);
		} catch(SQLException e) {
			throw new RuntimeException();
		} catch(IOException e) {
			throw new RuntimeException();
		}
		
		
	}
}
