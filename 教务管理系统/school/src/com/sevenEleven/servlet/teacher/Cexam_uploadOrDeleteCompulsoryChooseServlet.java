package com.sevenEleven.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CchooseTestBean;
import com.sevenEleven.javaBean.exam.Cexam;

/**
 * Servlet implementation class for Servlet: Cexam_uploadOrDeleteCompulsoryChooseServlet
 *
 */
 public class Cexam_uploadOrDeleteCompulsoryChooseServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cexam_uploadOrDeleteCompulsoryChooseServlet() {
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
		Cexam exam = new Cexam();
		
//		 这个if语句是对页面exam_updateOrDeleteTest.jsp的查看按钮的响应
		if (request.getParameter("cType") != null
				&& request.getParameter("cType").equals("mustChoose")) {
			CchooseTestBean choose = exam.getChoose1Table(request
					.getParameter("view"));
			if (choose.getType() == 1) {
				request.setAttribute("type", "必修课单选题");
				request.setAttribute("choose1", choose);
				request.getRequestDispatcher("exam_newPageUpdateChoose1.jsp")
						.forward(request, response);
			} else {
				request.setAttribute("type", "必修课多选题");
				request.setAttribute("choose2", choose);
				request.getRequestDispatcher("exam_newPageUpdateChoose2.jsp")
				.forward(request, response);
			}
		}
		// 这个if语句是对页面exam_updateOrDeleteTest.jsp的删除按钮的响应
		if (request.getParameter("dType") != null
				&& request.getParameter("dType").equals("mustChoose")) {
			String x = request.getParameter("delete");
			exam.deleteItemOfChoose1Table(x);
			request.getRequestDispatcher("Cexam_updateOrDeleteTestServlet")
			.forward(request, response);
		}
	}   	  	
	
}