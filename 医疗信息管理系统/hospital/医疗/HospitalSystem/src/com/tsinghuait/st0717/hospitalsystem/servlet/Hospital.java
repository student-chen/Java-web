package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hospital extends HttpServlet{
	/**
	 * 通过它跳转到主页面 
	 * */
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
	}
	public void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		this.doGet(arg0, arg1);
	}
}
