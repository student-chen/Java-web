package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CConnectMSSQL;

/**
 * Servlet implementation class for Servlet: ShowAllListServlet
 *
 */
 public class ShowAllListServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ShowAllListServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (("StudentInfo".equalsIgnoreCase(action)))
		{ 
		CConnectMSSQL db = new CConnectMSSQL();
		List list = db.getNestedListFromResultSet("select S_ID,S_NUMBER,S_NAME,C_NAME,C_TYPE from student,class where student.C_ID=class.C_ID");
		request.setAttribute("mylist", list);
		System.out.print(list);
		request.getRequestDispatcher("show_all_student.jsp").forward(request,
				response);		
		
		}  
		else if(("teacherinfo".equalsIgnoreCase(action)))
		{ 
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db.getNestedListFromResultSet("select T_ID,T_NUMBER,T_NAME,T_SKILL from teacher");
			request.setAttribute("mylist", list);
			//System.out.print(list);
			request.getRequestDispatcher("show_all_teacher.jsp").forward(request,
					response);		
			
			}  
		else if(("classinfo".equalsIgnoreCase(action)))
		{ 
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db.getNestedListFromResultSet("select C_ID,C_NAME,C_TYPE from CLASS");
			request.setAttribute("mylist", list);
			//System.out.print(list);
			request.getRequestDispatcher("show_all_class.jsp").forward(request,
					response);		
			
			} 
		else if(("lesson1_info".equalsIgnoreCase(action)))
		{ 
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db.getNestedListFromResultSet("select L1_ID,L1_NAME,L1_TIME,L1_SCORE from LESSON1");
			request.setAttribute("mylist", list);
			//System.out.print(list);
			request.getRequestDispatcher("show_all_lesson1.jsp").forward(request,
					response);		
			
			}  
		else if(("lesson2_info".equalsIgnoreCase(action)))
		{ 
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db.getNestedListFromResultSet("select L2_ID,L2_NAME,L2_NEED_ID,L2_TIME,L2_SCORE from LESSON2");
			request.setAttribute("mylist", list);
			//System.out.print(list);
			request.getRequestDispatcher("show_all_lesson2.jsp").forward(request,
					response);		
			
			}  
		
		
	}
}