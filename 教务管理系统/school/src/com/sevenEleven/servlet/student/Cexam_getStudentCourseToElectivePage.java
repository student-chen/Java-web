package com.sevenEleven.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CstudentBean;
import com.sevenEleven.javaBean.exam.CTakeExam;

/**
 * Servlet implementation class for Servlet: Cexam_getStudentCourseToElectivePage
 *
 */
 public class Cexam_getStudentCourseToElectivePage extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_getStudentCourseToElectivePage() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CTakeExam takeExam = new CTakeExam();
		CstudentBean student = new CstudentBean();
		request.setCharacterEncoding("gb2312");
		//取得session中student的信息
		//得到student的必修课程
		//得到student的所在班级名qq
		student = (CstudentBean)request.getSession().getAttribute("student");

		List courseList = takeExam.getStudentElectiveCourse(String.valueOf(student.getS_id()));
		String className = takeExam.getStudentClass(String.valueOf(student.getC_id()));
		request.setAttribute("courseList",courseList);
		
		request.setAttribute("className",className);
		request.getRequestDispatcher("exam_electivePage.jsp").forward(request, response);
	}   	  	    
}