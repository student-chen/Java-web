package com.sevenEleven.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CteacherBean;
import com.sevenEleven.javaBean.exam.Cexam;

/**
 * Servlet implementation class for Servlet: Cexam_addtest2Servlet
 *
 */
 public class Cexam_addtest2Servlet extends javax.servlet.http.HttpServlet  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3624633947809105566L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_addtest2Servlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 CteacherBean teacher = new CteacherBean();
		 Cexam exam = new Cexam();
		 teacher = (CteacherBean)
		 request.getSession().getAttribute("teacher");
		 List courseList = exam.findLesson2(teacher.getT_number());
		 request.setAttribute("courseList", courseList);
		 request.getRequestDispatcher("exam_addTest2.jsp").forward(request,
		 response);
	}   	  	    
}