package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import com.dao.Member_DAO;
import com.bean.Member;

public class Join_service {
	private Member_DAO mdao = new Member_DAO();
	
	public void join(Join_param jp) {
		System.out.println("- Join_service join");
		try {
			Member data = mdao.getMemberId(jp.getUser_id());
			if(data != null) {
				throw new RuntimeException();
			}
			mdao.insert(
				new Member(
					jp.getUser_id(),
					jp.getUser_pw(),
					new Date(),
					jp.getUser_email()
				)
			);
		} catch(SQLException e) { throw new RuntimeException(e);} catch(IOException e) { throw new RuntimeException(e); }
	}
}