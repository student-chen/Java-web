package com.sevenEleven.servlet.student;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sevenEleven.Beans.CstudentBean;
import com.sevenEleven.javaBean.student.CUsMethod;

/**
 * Servlet implementation class for Servlet: Lesson2CourseTable
 * 
 */
public class TiJiaoL2CourseTable extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public TiJiaoL2CourseTable() {
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
		Object crid = null;
		Object tid = null;
		Object timeid = null;
		String error;
		int judge;
		int aa;
		String success;
		String page;
		Object userid=((CstudentBean)request.getSession().getAttribute("student")).getS_number();
		String[] array = request.getParameterValues("checkbox");
		CUsMethod usmethod = new CUsMethod();
		Object sid = usmethod.getinformation(userid).getS_id();
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				Object l2Id = (Object) array[i];
				List list = usmethod.getPersonall2Id(l2Id);
				Iterator it = list.iterator();
				List listColumn = new LinkedList();
				while (it.hasNext()) {
					listColumn = (List) it.next();
					crid = listColumn.get(0);
					tid = listColumn.get(1);
					timeid = listColumn.get(3);
				}
//		boolean condition= usmethod.checkl1_l2(userid);
//		if(!condition)
//		{
//			error="你没有资格报该课";
//			request.setAttribute("errorMSG",error);
//			request.getRequestDispatcher("error.jsp").forward(request,response);
//			return;
//		}
//			judge = usmethod.JudgePersonalL2(l2Id,userid);
//				if (judge != 1) {
//					error = "该课程已存在!";
//					request.setAttribute("errorMSG", error);
//					request.getRequestDispatcher("error.jsp").forward(request,
//							response);
//					return;
//				}
				if (array.length > 1) {
					error = "不能同时选报超过1门课";
					request.setAttribute("errorMSG", error);
					request.getRequestDispatcher("error.jsp").forward(request,
							response);
					return;
				}

	//			aa = usmethod.judgeAmount(userid);
//				if (aa >= 2) {
//					error = "你已选报了两门课程!";
//					request.setAttribute("errorMSG", error);
//					request.getRequestDispatcher("error.jsp").forward(request,
//							response);
//					return;
//				} else
					usmethod.PersonalL2Info(sid, crid, tid, l2Id, timeid);
		}
			success="提交成功!";
			page="info_student.jsp";
			request.setAttribute("successMSG",success);
			request.setAttribute("location",page);
			request.getRequestDispatcher("successpage.jsp").forward(request, response);
			
		}
		if (array == null) {
			error = "请选定课程!";
			request.setAttribute("errorMSG", error);
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
			return;
		}
	}
}