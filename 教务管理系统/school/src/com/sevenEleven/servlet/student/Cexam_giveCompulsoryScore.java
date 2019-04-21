package com.sevenEleven.servlet.student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CstudentBean;
import com.sevenEleven.javaBean.exam.CoperationOfExam;

/**
 * Servlet implementation class for Servlet: Cexam_giveCompulsoryScore
 * 
 */
public class Cexam_giveCompulsoryScore extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_giveCompulsoryScore() {
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
		request.setCharacterEncoding("gb2312");
		CoperationOfExam operateExam = new CoperationOfExam();
		int choose1Mark = 0; // 单选题分数
		int choose2Mark = 0; // 多选题分数
		int textMark = 0; // 填空题分数
		// 计算单选分数
		for (int i = 1; i <= 10; i++) {
			if (request.getParameter("Key1" + i) == null || request.getParameter("Key1" + i) == "") {
				continue;
			}
			String curChoose1Answer = request.getParameter("Key1" + i);
			String curChoose1Id = request.getParameter("choose1id" + i);
			try {
				if (operateExam.Choose1IsRight(curChoose1Id, curChoose1Answer)) {
					choose1Mark += 2;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 计算多选分数
		for (int j = 1; j <= 10; j++) {
			if (request.getParameter("Key2" + j) == null || request.getParameter("Key2" + j) == "") {
				continue;
			}
			String[] curChoose2Answer = request.getParameterValues("Key2" + j);
			String curChoose2Id = request.getParameter("choose2id" + j);
			String Choose2Answer = null;
			for (int i = 0; i < curChoose2Answer.length; i++) {
				Choose2Answer += curChoose2Answer[i];
			}

			try {
				if (operateExam.Choose1IsRight(curChoose2Id, Choose2Answer)) {
					choose2Mark += 2;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 计算填空分数
		for (int k = 1; k <= 10; k++) {
			if (request.getParameter("text" + k) == null || request.getParameter("text" + k) == "") {
				continue;
			}
			String curTextAnswer = request.getParameter("text" + k);
			String curTextId = request.getParameter("textid" + k);
			try {
				if (operateExam.text1IsRight(curTextId, curTextAnswer)) {
					textMark += 2;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//String s = request.getParameter("courseId");
		CstudentBean student = (CstudentBean) request.getSession()
				.getAttribute("student");
		int sumMark = choose1Mark + choose2Mark + textMark;// 得到总分
		// 总分转成字符串型
		
		String s_mark = String.valueOf(sumMark);	
		// 填总分
		try {
			operateExam.insetCompulsoryE_Mark(String.valueOf(student.getS_id()),
					request.getParameter("courseId"), s_mark);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       //跳转页面
		request.setAttribute("choose1Mark",choose1Mark);//单选
		request.setAttribute("choose2Mark",choose2Mark);//多选
		request.setAttribute("textMark",textMark);//填空
		request.setAttribute("s_mark",s_mark);
		request.getRequestDispatcher("exam_displayCompulsoryMark.jsp").forward(request, response);
	}
}