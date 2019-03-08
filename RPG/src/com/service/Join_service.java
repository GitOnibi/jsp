package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import com.bean.Member;
import com.dao.Member_DAO;

public class Join_service {
	Member_DAO mdao = new Member_DAO();
	
	public void join(Join_param jp) throws IOException {
		System.out.println("- Join_service join");
		try {
			Member member = mdao.getMemberId(jp.getId());
			
			if(member != null) {
				throw new RuntimeException();
			}
			
			mdao.insert(
					new Member(
						jp.getId(),
						jp.getName(),
						jp.getPw(),
						new Date(),
						jp.getBirth()
					)
			);			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
