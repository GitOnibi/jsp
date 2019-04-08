package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Notice;
import com.bean.Notice_page;
import com.dao.Notice_DAO;

public class Notice_list_service {
	private Notice_DAO ndao = new Notice_DAO();
	private int size = 10;
	
	public Notice_page getPage(int pageNum) throws SQLException {
		try {
			int total = ndao.select_cnt();
			List<Notice> cont = ndao.select_notice((pageNum - 1) * size + (pageNum > 1 ? 1 : 0), size);
			return new Notice_page(total, pageNum, size, cont);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
