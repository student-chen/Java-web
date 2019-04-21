package com.tsinghuait.st0717.hospitalsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet{
	private final static int SAVE = 1;
	private final static int DELETE = 2;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		int operationInt = 0;
		if (operation != null){
			operationInt = Integer.parseInt(operation);
		}
		RequestDispatcher rd = null;
		switch (operationInt){
		case SAVE:
			rd = save(request,response);
			break;
		case DELETE:
			rd = delete(request,response);
			break;
		default:
			rd = search(request,response);
			break;
		}
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	//	±£´æ
	public abstract RequestDispatcher save(HttpServletRequest request,HttpServletResponse response);
	//  É¾³ý
	public abstract RequestDispatcher delete(HttpServletRequest request,HttpServletResponse response);
	//  ²éÑ¯
	public abstract RequestDispatcher search(HttpServletRequest request,HttpServletResponse response);
}
