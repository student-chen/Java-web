package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CDBOracle;

/**
 * Servlet implementation class for Servlet: SchemeUpdateServlet
 *
 */
 public class SchemeUpdateServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public SchemeUpdateServlet() {
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
		String TIME_ID = request.getParameter("TIME_ID");
		String C_NAME = request.getParameter("C_NAME");
		String L1_NAME = request.getParameter("L1_NAME");
		String T_NAME = request.getParameter("T_NAME");
		String CR_NAME = request.getParameter("CR_NAME");
		// String actionregister = request.getParameter("action");
		/*
		 * System.out.print(sid); System.out.print(name);
		 * System.out.print(password); System.out.print(password2);
		 * System.out.print(cname);
		 */
		String sql = "update lesson1_list set C_ID=(select C_ID from class where C_NAME='"+C_NAME+"'),L1_ID=(select L1_ID from lesson1 where L1_NAME='"+L1_NAME+"'),T_ID=(select T_ID from teacher where T_NAME='"+T_NAME+"'),CR_ID=(select CR_ID from classroom where CR_NAME='"+CR_NAME+"') where TIME_ID='"+TIME_ID+"'";
		// CConnectMSSQL db = new CConnectMSSQL();
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