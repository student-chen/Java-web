package com.sevenEleven.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CchooseTestBean;
import com.sevenEleven.javaBean.exam.Cexam;

/**
 * Servlet implementation class for Servlet: Cexam_newPageUpdateChoose1
 * 
 */
public class Cexam_newPageUpdateChoose1 extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_newPageUpdateChoose1() {
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
		doPost(request, response);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		µ¥Ñ¡µÄupdate
		Cexam exam = new Cexam();
		CchooseTestBean choose = new CchooseTestBean();
		choose.setCh_id(request.getParameter("choose1_id"));
		choose.setCh_question(request.getParameter("choose1_head"));
		choose.setKeya(request.getParameter("choose1_keya"));
		choose.setKeyb(request.getParameter("choose1_keyb"));
		choose.setKeyc(request.getParameter("choose1_keyc"));
		choose.setKeyd(request.getParameter("choose1_keyd"));
		choose.setAnswer(request.getParameter("choose1_answer"));
		if (exam.updateChoose1Table(choose)) {	
		} else if (exam.updateChoose2Table(choose)) {
		}
	  request.getRequestDispatcher("exam_newPageUpdateChoose1.jsp").forward(request,response);
	}

}