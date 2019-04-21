package com.sevenEleven.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.exam.Cexam;

/**
 * Servlet implementation class for Servlet: Cexam_testExamServlet
 *
 */
 public class Cexam_testExamServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2193473008876509723L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_testExamServlet() {
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
		request.setCharacterEncoding("gb2312");
		Cexam exam = new Cexam();
		 exam.setCountOfChoose1("2");
		  exam.setCountOfChoose2("2");
		  exam.setCountOfText("2");
       // request.setAttribute("compulsoryPaper",exam.makeCompulsoryTestPaper("2","2","2"));
        request.setAttribute("countOfChoose1","2");
        request.setAttribute("countOfChoose2","2");
        request.setAttribute("countOfText","2");
        request.getRequestDispatcher("exam_testExam.jsp").forward(request, response);
	}   	  	    
}