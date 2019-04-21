package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CConnectMSSQL;

/**
 * Servlet implementation class for Servlet: ChangeLesson2Servlet
 *
 */
 public class ChangeLesson2Servlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ChangeLesson2Servlet() {
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
		String L2_ID = request.getParameter("L2_ID");
		//System.out.print(t_id);
		if (("findonelesson2info".equalsIgnoreCase(action))) {
			/*String sql = "select "+student_id+" from student";*/
			String sql = "select L2_ID,L2_NAME,L2_NEED_ID from lesson2 where L2_ID="+L2_ID;
			//String sqlsql = "select C_ID,C_NAME from class";
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db
					.getNestedListFromResultSet(sql);
			request.setAttribute("mylist", list);
			//CConnectMSSQL db2 = new CConnectMSSQL();
			//List list2 = db2.getNestedListFromResultSet(sqlsql);
			String sql2 = "select L1_ID,L1_NAME from lesson1";
			CConnectMSSQL db2 = new CConnectMSSQL();
			List list2 = db2.getNestedListFromResultSet(sql2);
			request.setAttribute("mylist2", list2);// 提取班级信息资料并封装成对象送到学生注册页面
			//System.out.print(list);
			
		
			//request.setAttribute("mylist2",list2);
		    //System.out.print(list);
		    //System.out.print(list2);
			request.getRequestDispatcher("Lesson2Changer.jsp").forward(
					request, response);

		}
	}   	  	    
}