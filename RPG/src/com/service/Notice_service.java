package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import com.bean.Notice;
import com.bean.Notice_content;
import com.dao.Notice_DAO;
import com.dao.Notice_cont_DAO;

public class Notice_service {
	private Notice_DAO ndao = new Notice_DAO();
	private Notice_cont_DAO ncdao = new Notice_cont_DAO();
	
	public int write(Write_param wp) {
		try {
			Notice data = toNotice(wp);
			Notice save = ndao.insert(data);
			if(save == null) {
				throw new RuntimeException("글 쓰기 실패");
			}
			Notice_content cont = new Notice_content(save.getNumber(), wp.getContent());
			Notice_content save_cont = ncdao.insert(cont);
			if(save_cont == null) {
				throw new RuntimeException("글 저장 실패");
			}
			return save.getNumber();
		} catch(SQLException e) {
			throw new RuntimeException("Notice_service SQLException" + e);
		} catch(IOException e) {
			throw new RuntimeException("Notice_service IOException" + e);
		}
	}
	
	public Notice toNotice(Write_param wp) throws SQLException, IOException {
		Date now = new Date();
		return new Notice(
			ndao.getNum(),
			wp.getUser_id(),
			wp.getTitle(),
			now,
			now,
			0
		);
	}
}
