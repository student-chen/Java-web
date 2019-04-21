package com.sevenEleven.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CteacherBean;
import com.sevenEleven.javaBean.exam.Cexam;

/**
 * Servlet implementation class for Servlet: Cexam_addtestServlet
 * 
 */
public class Cexam_addtestServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 38472189172411921L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_addtestServlet() {
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		 CteacherBean teacher = new CteacherBean();
		 Cexam exam = new Cexam();
		 teacher = (CteacherBean)
		 request.getSession().getAttribute("teacher");
		 List courseList = exam.findLesson1(teacher.getT_number());
		 request.setAttribute("courseList", courseList);
		 request.getRequestDispatcher("exam_addTest.jsp").forward(request,
		 response);
		 //response.sendRedirect("teacher.jsp");


	}
}