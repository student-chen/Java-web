package com.sevenEleven.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CtextTestBean;
import com.sevenEleven.javaBean.exam.Cexam;

/**
 * Servlet implementation class for Servlet: Cexam_newPageUpdateText
 *
 */
 public class Cexam_newPageUpdateText extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_newPageUpdateText() {
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

//		Ìî¿ÕµÄupdate
		Cexam exam = new Cexam();
		CtextTestBean text = new CtextTestBean();
		text.setText_id(request.getParameter("text_id"));
		text.setText_question(request.getParameter("text_question"));
		text.setText_answer(request.getParameter("text_answer"));
		if (exam.updateText1Table(text)) {	
		} else if (exam.updateText2Table(text)) {
		}
	  request.getRequestDispatcher("exam_newPageUpdateText.jsp").forward(request,response);

	}   	  	    
}