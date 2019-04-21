package com.sevenEleven.servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.exam.CTakeExam;

/**
 * Servlet implementation class for Servlet: Cexam_getElectivePaperToElectiveTestPage
 *
 */
 public class Cexam_getElectivePaperToElectiveTestPage extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_getElectivePaperToElectiveTestPage() {
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
		request.setCharacterEncoding("gb2312");
		CTakeExam exam = new CTakeExam();
		String courseId = request.getParameter("course");
		request.setAttribute("compulsoryPaper",exam.makeCompulsoryTestPaper(courseId,"10","10","10"));
		request.setAttribute("courseId",courseId);
        request.setAttribute("countOfChoose1","10");
        request.setAttribute("countOfChoose2","10");
        request.setAttribute("countOfText","10");
        request.getRequestDispatcher("exam_displayAllElectiveCourse.jsp").forward(request, response);
	}   	  	    
}