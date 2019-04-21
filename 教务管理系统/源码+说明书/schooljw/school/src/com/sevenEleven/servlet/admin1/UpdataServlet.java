package com.sevenEleven.servlet.admin1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CDBConnection;

/**
 * Servlet implementation class for Servlet: UpdataServlet
 *
 */
 public class UpdataServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public UpdataServlet() {
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
		//修改管理员信息，并将它放入数据库中
		String AID = request.getParameter("aid");
		String NAME = request.getParameter("username");
		String PASSWORD = request.getParameter("password");
		String LoginType = request.getParameter("LoginType");
        String sql = "update administrator set a_id='" + AID + "',a_name='"
				+ NAME + "',a_password='" + PASSWORD + "',a_type="+LoginType+ "where a_id="+ AID;
		// CConnectMSSQL db = new CConnectMSSQL();
		//System.out.print(sql);
		CDBConnection db = new CDBConnection();

		db.executeUpdate(sql);
		db.execute("commit");
		// System.out.print("success!!!!??");

		// request.getRequestDispatcher("show_all_student.jsp").forward(
		// request, response);
		response.sendRedirect("info_admin_systerm.jsp");

	}

	}   	  	    
