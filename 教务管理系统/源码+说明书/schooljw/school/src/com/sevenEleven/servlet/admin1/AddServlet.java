package com.sevenEleven.servlet.admin1;

import java.io.IOException;
 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CDBConnection;
/**
 * Servlet implementation class for Servlet: AddServlet
 *
 */
 public class AddServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AddServlet() {
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
		//添加管理员，将信息放入数据库
		request.setCharacterEncoding("gb2312");
		response.setCharacterEncoding("gb2312");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		//String password2 = request.getParameter("password2");
		String LoginType = request.getParameter("LoginType");
		//String actionregister = request.getParameter("action");
		//System.out.print(userName);
		//System.out.print(name);
		//System.out.print(password);
		//System.out.print(password2);
		//System.out.print(cname);

		
	    //String sql = "insert into student vaules (seq_student_p.nextval,"+cname+",'"+name+"','"+userName+"','"+password+"')";     
		String sql = "insert into administrator values (seq_admin_p.nextval,'"+password+"','"+LoginType+"','"+userName+"')"; 
			//CConnectMSSQL db = new CConnectMSSQL();
		CDBConnection db = new CDBConnection();
		//System.out.print(sql);
	    db.executeUpdate(sql);
	    db.execute("commit");
		//System.out.print("success!!!!??");
			
		//request.getRequestDispatcher("show_all_student.jsp").forward(
					//request, response);
	    response.sendRedirect("info_admin_systerm.jsp");
	 }   
	}

 	    
