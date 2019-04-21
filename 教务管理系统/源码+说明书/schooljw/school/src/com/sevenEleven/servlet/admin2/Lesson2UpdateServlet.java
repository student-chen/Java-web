package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CDBOracle;

/**
 * Servlet implementation class for Servlet: Lesson2UpdateServlet
 *
 */
 public class Lesson2UpdateServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Lesson2UpdateServlet() {
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
		String L2_ID = request.getParameter("L2_ID");
		String L2_NAME = request.getParameter("L2_NAME");
		String L2_NEED_ID = request.getParameter("L2_NEED_ID");
		
		String sql = "update lesson2 set L2_NAME='"+L2_NAME+"',L2_NEED_ID='"+L2_NEED_ID+"' where L2_ID=" + L2_ID;
		// CConnectMSSQL db = new CConnectMSSQL();
	   // System.out.print(sql);
		CDBOracle db = new CDBOracle();

		db.executeUpdate(sql);
		db.execute("commit");
		// System.out.print("success!!!!??");

		// request.getRequestDispatcher("show_all_student.jsp").forward(
		// request, response);
		response.sendRedirect("info_admin.jsp");
	}   	  	    
}