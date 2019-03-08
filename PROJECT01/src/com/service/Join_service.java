package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import com.dao.Member_DAO;
import com.model.Member;

public class Join_service {
	private Member_DAO mdao = new Member_DAO();
	
	public void join(Join_param jp) {
		System.out.println("- Join_service join");
		try {
			Member data = mdao.getMemberId(jp.getId());
			if(data != null) {
				System.out.println("- id data not null");
				throw new RuntimeException();
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
		System.out.println("- id insert complate");
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}