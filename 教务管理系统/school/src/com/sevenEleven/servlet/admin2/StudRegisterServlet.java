package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CDBOracle;

/**
 * Servlet implementation class for Servlet: StudRegisterServlet
 *
 */
 public class StudRegisterServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public StudRegisterServlet() {
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
		
		String userName = request.getParameter("username");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//String password2 = request.getParameter("password2");
		String cname = request.getParameter("cname");
		//String actionregister = request.getParameter("action");
		//System.out.print(userName);
		//System.out.print(name);
		//System.out.print(password);
		//System.out.print(password2);
		//System.out.print(cname);

		
	    //String sql = "insert into student vaules (seq_student_p.nextval,"+cname+",'"+name+"','"+userName+"','"+password+"')";     
		  String sql = "insert into student values ("+cname+",'"+name+"','"+userName+"','"+password+"')"; 
			//CConnectMSSQL db = new CConnectMSSQL();
		CDBOracle db = new CDBOracle();
		//System.out.print(sql);
	    db.executeUpdate(sql);
	    db.execute("commit");
		//System.out.print("success!!!!??");
			
		//request.getRequestDispatcher("show_all_student.jsp").forward(
					//request, response);
	    response.sendRedirect("info_admin.jsp");
	}   	  	    
}