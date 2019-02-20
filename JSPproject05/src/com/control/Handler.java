package com.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {
	public String processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
