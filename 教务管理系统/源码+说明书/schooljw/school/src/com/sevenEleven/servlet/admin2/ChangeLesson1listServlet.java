package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CConnectMSSQL;

/**
 * Servlet implementation class for Servlet: ChangeLesson1listServlet
 * 
 */
public class ChangeLesson1listServlet extends javax.servlet.http.HttpServlet
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
	public ChangeLesson1listServlet() {
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

		String action = request.getParameter("action");
		String TIME_ID = request.getParameter("TIME_ID");
		String C_ID = request.getParameter("C_ID");
		String L1_NAME = request.getParameter("L1_NAME");
		String T_NAME = request.getParameter("T_NAME");
		String CR_NAME = request.getParameter("CR_NAME");
		System.out.print(action);
		System.out.print(TIME_ID);
		System.out.print(C_ID);
		System.out.print(L1_NAME);
		System.out.print(T_NAME);
		System.out.print(CR_NAME);

		// if (("findoneschemeinfo".equalsIgnoreCase(action))) {
		/* String sql = "select "+student_id+" from student"; */
		String sql = "SELECT TIME.TIME_ID,C_NAME,L1_NAME,T_NAME,CR_NAME FROM CLASS,TIME,LESSON1,TEACHER,CLASSROOM,LESSON1_LIST WHERE CLASS.C_ID=LESSON1_LIST.C_ID AND TIME.TIME_ID=LESSON1_LIST.TIME_ID AND LESSON1.L1_ID=LESSON1_LIST.L1_ID AND TEACHER.T_ID=LESSON1_LIST.T_ID AND CLASSROOM.CR_ID=LESSON1_LIST.CR_ID AND LESSON1_LIST.TIME_ID='"
				+ TIME_ID
				+ "' AND CLASS.C_NAME='"
				+ C_ID
				+ "' AND L1_NAME='"
				+ L1_NAME
				+ "' AND T_NAME='"
				+ T_NAME
				+ "' AND CR_NAME='"
				+ CR_NAME + "'";
		// String sqlsql = "select C_ID,C_NAME from class";
		CConnectMSSQL db = new CConnectMSSQL();
		List list = db.getNestedListFromResultSet(sql);
		// CConnectMSSQL db2 = new CConnectMSSQL();
		// List list2 = db2.getNestedListFromResultSet(sqlsql);
		request.setAttribute("mylist", list);
		// request.setAttribute("mylist2",list2);

		// System.out.print(list2);
		request.getRequestDispatcher("OneSchemeChanger.jsp").forward(request,
				response);

		// }

	}
}