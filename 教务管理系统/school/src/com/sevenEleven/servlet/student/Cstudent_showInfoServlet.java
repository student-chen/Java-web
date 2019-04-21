package com.sevenEleven.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CstudentBean;
import com.sevenEleven.javaBean.student.CUsMethod;

/**
 * Servlet implementation class for Servlet: Cstudent_showInfoServlet
 * 
 */
public class Cstudent_showInfoServlet extends javax.servlet.http.HttpServlet {
		//implements javax.servlet.Servlet {
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cstudent_showInfoServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//CstudentBean student = new CstudentBean();
		Object userid = ((CstudentBean) request.getSession().getAttribute("student")).getS_number();
		CUsMethod usmethod = new CUsMethod();
		//student = usmethod.getinformation(userid);

		List list = usmethod.getNestedListFromResultSet(userid);
		request.setAttribute("info", list);
		request.getRequestDispatcher("showinfo.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}