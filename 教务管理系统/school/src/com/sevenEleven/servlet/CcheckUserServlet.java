package com.sevenEleven.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CadminBean;
import com.sevenEleven.Beans.CstudentBean;
import com.sevenEleven.Beans.CteacherBean;
import com.sevenEleven.javaBean.CcheckUser;

/**
 * Servlet implementation class for Servlet: CcheckUserServlet
 * 
 */
public class CcheckUserServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4061025680582998159L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CcheckUserServlet() {
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
	 *      HttpServletResponse response) author: Tim
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 出login页面中提出userName 和userPassword 及userType
		String userName = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		String userType = request.getParameter("userType");
		// 调用CcheckUser来处理
		CcheckUser check = null;
		try {
			check = new CcheckUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//         if(!check.checkNet()){
//        	 request.getSession().setAttribute("errorMessage","网络中断!!");
//        	 request.getRequestDispatcher("error500.jsp").forward(request, response);
//         }
         if (userType.equals("3")) {
			CstudentBean student = check.checkStudentLogin(userName, password);
			if (student != null) {
				request.getSession().setAttribute("student", student);
				request.getSession().setAttribute("isLog", "true");
				request.getRequestDispatcher("student/student.jsp").forward(
						request, response);
				// response.sendRedirect("student/student.jsp");
			} else {

			}
		} else if (userType.equals("2")) {
			CteacherBean teacher = check.checkTeacherLogin(userName, password);
			if (teacher != null) {
				request.getSession().setAttribute("teacher", teacher);
				request.getSession().setAttribute("isLog", "true");
				request.getRequestDispatcher("teacher/teacher.jsp").forward(
						request, response);
//				response.sendRedirect("teacher/teacher.jsp");
			}
		} else if (userType.equals("1")) {
			CadminBean admin = check.checkAdminLogin(userName, password);
			if (admin != null) { // 判断用admin类型的用户是否存在
				request.getSession().setAttribute("isLog", "true");
				if (admin.getA_type() == 1) { //
					request.getSession().setAttribute("adminSysterm", admin);
					request.getRequestDispatcher("admin_systerm/admin_systerm.jsp").forward(
							request, response);
					// response.sendRedirect("admin_systerm/admin_systerm.jsp");
				} else if (admin.getA_type() == 2) {
					request.getSession().setAttribute("adminTeach", admin);
					request.getRequestDispatcher("admin_teach/admin.jsp").forward(
							request, response);
				} else {
					request.getSession().setAttribute("adminBook", admin);
					request.getRequestDispatcher("admin_book/admin_book.jsp").forward(
							request, response);
				}
			}
		} else {
			request.getSession().setAttribute("isLog", "false");
			response.sendError(1, "尝试非法登录无效!!");
		}

	
	}
}