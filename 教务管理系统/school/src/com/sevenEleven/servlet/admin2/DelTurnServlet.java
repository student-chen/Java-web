package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CConnectMSSQL;

/**
 * Servlet implementation class for Servlet: DelTurnServlet
 *
 */
 public class DelTurnServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public DelTurnServlet() {
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
		String action = request.getParameter("action");
		//
		if(("del_student".equalsIgnoreCase(action)))
		{ 
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db.getNestedListFromResultSet("select S_ID,S_NUMBER,S_NAME,C_NAME,C_TYPE from student,class where student.C_ID=class.C_ID");
			request.setAttribute("mylist", list);
			//System.out.print(list);
			request.getRequestDispatcher("del_one_student_info.jsp").forward(request,
					response);		
			
			}  
		if(("del_teacher".equalsIgnoreCase(action)))
		{ 
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db.getNestedListFromResultSet("select T_ID,T_NUMBER,T_NAME,T_SKILL from teacher");
			request.setAttribute("mylist", list);
			//System.out.print(list);
			request.getRequestDispatcher("del_one_teacher_info.jsp").forward(request,
					response);		
			
			}  
		if(("del_class".equalsIgnoreCase(action)))
		{ 
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db.getNestedListFromResultSet("select C_ID,C_NAME,C_TYPE from CLASS");
			request.setAttribute("mylist", list);
			//System.out.print(list);
			request.getRequestDispatcher("del_one_class_info.jsp").forward(request,
					response);		
			
			}  
		if(("del_lesson1".equalsIgnoreCase(action)))
		{ 
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db.getNestedListFromResultSet("select L1_ID,L1_NAME from LESSON1");
			request.setAttribute("mylist", list);
			//System.out.print(list);
			request.getRequestDispatcher("del_one_lesson1_info.jsp").forward(request,
					response);		
			
			}  
		if(("del_lesson2".equalsIgnoreCase(action)))
		{ 
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db.getNestedListFromResultSet("select L2_ID,L2_NAME,L2_NEED_ID from LESSON2");
			request.setAttribute("mylist", list);
			//System.out.print(list);
			request.getRequestDispatcher("del_one_lesson2_info.jsp").forward(request,
					response);		
			
			}  
		
		
		
		
		
		
		
		
		
		
		
	}   	  	    
}