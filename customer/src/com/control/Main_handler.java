package com.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Main_handler {
	public String action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;
}
