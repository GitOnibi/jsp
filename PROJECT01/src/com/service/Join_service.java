package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import com.dao.Member_DAO;
import com.model.Member;

public class Join_service {
	Member_DAO mdao = new Member_DAO();
	
	public void join(Join_param jp) {
		try {
			Member data = mdao.getMemberId(jp.getId());
			if(data != null) {
				// 아이디 중복 시
			}
			mdao.insert(
				new Member(
					jp.getId(),
					jp.getName(),
					jp.getPassword(),
					new Date(),
					jp.getBirth()
				)
			);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
