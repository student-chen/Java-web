package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CDBOracle;

/**
 * Servlet implementation class for Servlet: Lesson2RegisterServlet
 * 
 */
public class Lesson2RegisterServlet extends javax.servlet.http.HttpServlet
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
	public Lesson2RegisterServlet() {
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
		String lesson2name = request.getParameter("lesson2name");
		String lesson2needid = request.getParameter("lesson2needid");
		String lesson2time = request.getParameter("lesson2time");
		String lesson2score = request.getParameter("lesson2score");

		String sql = "insert into lesson2 values ('"+lesson2name+"',"+lesson2needid+","+lesson2time+","+lesson2score+")"; 
	    //System.out.print(sql);
		CDBOracle db = new CDBOracle();
		db.executeUpdate(sql);
		db.execute("commit");
		// System.out.print("success!!!!??");

		// request.getRequestDispatcher("show_all_student.jsp").forward(
		// request, response);
		response.sendRedirect("info_admin.jsp");

	}
}