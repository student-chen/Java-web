package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CConnectMSSQL;

/**
 * Servlet implementation class for Servlet: StudentRegisterServlet
 * 
 */
public class RegisterTurnServlet extends javax.servlet.http.HttpServlet
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
	public RegisterTurnServlet() {
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
		String action = request.getParameter("action");

		if (("studentregister".equalsIgnoreCase(action))) {
			/* String sql = "select "+student_id+" from student"; */
			String sql = "select C_ID,C_NAME from class";
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db.getNestedListFromResultSet(sql);
			request.setAttribute("mylist", list);// 提取班级信息资料并封装成对象送到学生注册页面
			 System.out.print(list);
			request.getRequestDispatcher("StudentRegister.jsp").forward(
					request, response);// 转向到学生注册页面

		}
		if (("teacherregister".equalsIgnoreCase(action))) {

			request.getRequestDispatcher("TeacherRegister.jsp").forward(
					request, response);// 转向到老师注册页面

		}
		if (("classregister".equalsIgnoreCase(action))) {

			request.getRequestDispatcher("ClassRegister.jsp").forward(
					request, response);// 转向到班级注册页面

		}
		if (("lesson1register".equalsIgnoreCase(action))) {

			request.getRequestDispatcher("Lesson1Register.jsp").forward(
					request, response);// 转向到必修课注册页面

		}
		if (("lesson2register".equalsIgnoreCase(action))) {
			String sql = "select L1_ID,L1_NAME from lesson1";
			CConnectMSSQL db = new CConnectMSSQL();
			List list = db.getNestedListFromResultSet(sql);
			request.setAttribute("mylist", list);// 提取班级信息资料并封装成对象送到学生注册页面
			//System.out.print(list);
			request.getRequestDispatcher("Lesson2Register.jsp").forward(
					request, response);// 转向到选修课注册页面

		}

	}
}