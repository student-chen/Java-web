package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CConnectMSSQL;

/**
 * Servlet implementation class for Servlet: ChangeStudentServlet
 * 
 */
public class ChangeStudentServlet extends javax.servlet.http.HttpServlet
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
	public ChangeStudentServlet() {
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
		String student_id = request.getParameter("s_id");
		
		if (("findonestudentinfo".equalsIgnoreCase(action))) {
			/*String sql = "select "+student_id+" from student";*/
			String sql = "select S_ID,S_NUMBER,S_NAME,C_NAME,C_TYPE from student,class where student.C_ID=class.C_ID and S_ID="+student_id;
			String sqlsql = "select C_ID,C_NAME from class";
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db
					.getNestedListFromResultSet(sql);
			CConnectMSSQL db2 = new CConnectMSSQL();
			List list2 = db2.getNestedListFromResultSet(sqlsql);
			request.setAttribute("mylist", list);
			request.setAttribute("mylist2",list2);
		    //System.out.print(list);
		    //System.out.print(list2);
			request.getRequestDispatcher("StudentChanger.jsp").forward(
					request, response);

		}

	}
}