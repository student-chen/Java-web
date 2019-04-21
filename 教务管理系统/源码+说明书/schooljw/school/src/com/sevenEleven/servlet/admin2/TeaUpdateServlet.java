package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CDBOracle;

/**
 * Servlet implementation class for Servlet: TeaUpdateServlet
 *
 */
 public class TeaUpdateServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public TeaUpdateServlet() {
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
		String TID = request.getParameter("tid");
		String TNUMBER = request.getParameter("tnumber");
		String TNAME = request.getParameter("tname");
		String TPASSWORD = request.getParameter("password");
		String TSKILL = request.getParameter("tskill");
		// String actionregister = request.getParameter("action");
		/*
		 * System.out.print(sid); System.out.print(name);
		 * System.out.print(password); System.out.print(password2);
		 * System.out.print(cname);
		 */
		String sql = "update teacher set T_NAME='" + TNAME + "',T_NUMBER='"
				+ TNUMBER + "',T_PASSWORD='" + TPASSWORD + "',T_SKILL='" + TSKILL
				+ "' where T_ID=" + TID;
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