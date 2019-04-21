package com.sevenEleven.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CchooseTestBean;
import com.sevenEleven.Beans.CtextTestBean;
import com.sevenEleven.javaBean.exam.Cexam;

/**
 * Servlet implementation class for Servlet: Cexam_uploadTest2Servlet
 * 
 */
public class Cexam_uploadTest2Servlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1035842622989127924L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_uploadTest2Servlet() {
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
	
		Cexam exam = new Cexam();
		CchooseTestBean choose = new CchooseTestBean();
		CtextTestBean text = new CtextTestBean();
		String isRight = new String();
		// CchooseTestBean
		int testType = Integer.parseInt(request.getParameter("testType"), 10);
		if (testType == 1) { // 选修课单选题的操作
			choose.setCh_id("seq_choose2_p.nextval");
			choose.setCh_question((String) request.getParameter("choose1_head"));
			choose.setKeya((String) request.getParameter("choose1_Keya"));
			choose.setKeyb((String) request.getParameter("choose1_Keyb"));
			choose.setKeyc((String) request.getParameter("choose1_Keyc"));
			choose.setKeyd((String) request.getParameter("choose1_Keyd"));
			// 得到课程的ID
			String couse = request.getParameter("course");
			int L2_id = exam.getLesson2Id(couse);
			choose.setL_id(L2_id);
			choose.setType(testType);
			//
			choose.setAnswer(request.getParameter("Key1"));
			if (exam.insertIntoChoose2Table(choose))
				isRight = "yes";
			else
				isRight = "no";
		} else if (testType == 2) {// 选修课多选题的操作
			choose.setCh_id("seq_choose2_p.nextval");
			choose
					.setCh_question((String) request
							.getParameter("choose2_head"));
			choose.setKeya((String) request.getParameter("choose2_Keya"));
			choose.setKeyb((String) request.getParameter("choose2_Keyb"));
			choose.setKeyc((String) request.getParameter("choose2_Keyc"));
			choose.setKeyd((String) request.getParameter("choose2_Keyd"));
			// 得到课程的ID
			String couse = request.getParameter("course");
			int L2_id = exam.getLesson2Id(couse);
			choose.setL_id(L2_id);
			choose.setType(testType);
			//
			choose.setType(testType);
			// check的用法
			String answer = "";
			String[] checks = request.getParameterValues("Key2");
			for (int i = 0; i < checks.length; i++) {
				answer += checks[i];
			}
			choose.setAnswer(answer);
			if (exam.insertIntoChoose2Table(choose))
				isRight = "yes";
			else
				isRight = "no";
		} else if (testType == 3) {// 选修课填空题的操作
			text.setText_id("seq_text2_p.nextval");
			// 得到课程的ID
			String couse = request.getParameter("course");
			int L2_id = exam.getLesson2Id(couse);
			text.setL_id(L2_id);
			//
			text.setText_question(request.getParameter("text_head"));
			text.setText_answer(request.getParameter("Key"));
			if (exam.insertIntoText2Table(text))
				isRight = "yes";
			else
				isRight = "no";
		} else {
			isRight = "no";
		}
		//request.setAttribute("isRight", isRight);
		request.getRequestDispatcher("Cexam_addtest2Servlet").forward(request,
				response);

	}
}