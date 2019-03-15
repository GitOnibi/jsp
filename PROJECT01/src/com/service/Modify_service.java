package com.service;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.Member_DAO;
import com.model.Member;

public class Modify_service {
	private Member_DAO mdao = new Member_DAO();
	
	public void changeInfo(String id, String name, String birth) {
		try {
			Member data = mdao.getMemberId(id);
			
			if(data == null) throw new RuntimeException();
			
			data.chg_info(name, birth);
			mdao.update_info(data);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
}