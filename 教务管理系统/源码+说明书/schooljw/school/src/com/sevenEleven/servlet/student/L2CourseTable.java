package com.sevenEleven.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sevenEleven.javaBean.student.CUsMethod;

/**
 * Servlet implementation class for Servlet: SelectCourseTable
 * 
 */
public class L2CourseTable extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public L2CourseTable() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	 CUsMethod usmethod=new CUsMethod();
	 List list=usmethod.getLesson2Info();
	 List listid=usmethod.getL2Id();
	request.setAttribute("lesson2",list);
	request.setAttribute("l2id",listid);
	request.getRequestDispatcher("xuanxiuke.jsp").forward(request,response);
	}
}