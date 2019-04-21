package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CConnectMSSQL;
import com.sevenEleven.javaBean.admin_test.CmakeTeacherAndCourseTogether;

/**
 * Servlet implementation class for Servlet: SchemeTurnServlet
 * 
 */
public class SchemeTurnServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public SchemeTurnServlet() {
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
		if (("makescheme".equalsIgnoreCase(action))) {
			// 从数据库中提取时间信息提交到排课页面
			String sqltime = "select TIME_ID from TIME";
			CConnectMSSQL time = new CConnectMSSQL();
			List timelist = time.getNestedListFromResultSet(sqltime);
			request.setAttribute("time", timelist);
			// System.out.print(time);
			// 从数据库中提取教室信息提交到排课页面
			String sqlclassroom = "select CR_ID,CR_NAME from CLASSROOM";
			CConnectMSSQL classroom = new CConnectMSSQL();
			List classroomlist = classroom
					.getNestedListFromResultSet(sqlclassroom);
			request.setAttribute("classroom", classroomlist);
			// //从数据库中提取老师信息提交到排课页面
			String sqlteacher = "select T_ID,T_NAME from teacher";
			CConnectMSSQL teacher = new CConnectMSSQL();
			List teacherlist = teacher.getNestedListFromResultSet(sqlteacher);
			request.setAttribute("teacher", teacherlist);
			// //从数据库中提取必修课程信息提交到排课页面
			String sqllesson1 = "select L1_ID,L1_NAME from lesson1";
			CConnectMSSQL lesson1 = new CConnectMSSQL();
			List lesson1list = lesson1.getNestedListFromResultSet(sqllesson1);
			request.setAttribute("lesson1", lesson1list);
			// //从数据库中提取班级信息提交到排课页面
			String sqlclass = "select C_ID,C_NAME from class";
			CConnectMSSQL classinfo = new CConnectMSSQL();
			List classlist = classinfo.getNestedListFromResultSet(sqlclass);
			request.setAttribute("class", classlist);
			// System.out.print(list);
			request.getRequestDispatcher("MakeScheme.jsp").forward(request,
					response);// 转向到班级日排课提交器页面
			return;

		}
		if (("showscheme".equalsIgnoreCase(action))) {
			// 从数据库中提取时间信息提交到排课页面
			String sqltime = "SELECT C_NAME,TIME.TIME_ID,L1_NAME,T_NAME,CR_NAME FROM CLASS,TIME,LESSON1,TEACHER,CLASSROOM,LESSON1_LIST WHERE CLASS.C_ID=LESSON1_LIST.C_ID AND TIME.TIME_ID=LESSON1_LIST.TIME_ID AND LESSON1.L1_ID=LESSON1_LIST.L1_ID AND TEACHER.T_ID=LESSON1_LIST.T_ID AND CLASSROOM.CR_ID=LESSON1_LIST.CR_ID";
			/*
			 * <th width="20%">班级名</th> <th width="20%">时间</th>
			 * <th width="20%">课程</th> <th width="20%">老师</th>
			 * <th width="20%">教室</th>
			 */
			// String sqltime = "select * from LESSON1_LIST";
			CConnectMSSQL time = new CConnectMSSQL();
			List list = time.getNestedListFromResultSet(sqltime);
			request.setAttribute("mylist", list);
			request.getRequestDispatcher("Show_all_lesson1list.jsp").forward(
					request, response);
			return;
		}
		if (("makeweekscheme".equalsIgnoreCase(action))) {

			String sqlclass = "select C_ID,C_NAME from class";
			CConnectMSSQL classinfo = new CConnectMSSQL();
			List classlist = classinfo.getNestedListFromResultSet(sqlclass);
			request.setAttribute("class", classlist);
			// System.out.print(classlist);
			request.getRequestDispatcher("ClassSelectScheme.jsp").forward(
					request, response);
			return;
		}
		if (("makeonescheme".equalsIgnoreCase(action))) {
			// 从数据库中提取时间信息提交到排课页面
			String sqltime = "select TIME_ID from TIME";
			CConnectMSSQL time = new CConnectMSSQL();
			List timelist = time.getNestedListFromResultSet(sqltime);
			request.setAttribute("time", timelist);
			// System.out.print(time);
			// 从数据库中提取教室信息提交到排课页面
			String sqlclassroom = "select CR_ID,CR_NAME from CLASSROOM";
			CConnectMSSQL classroom = new CConnectMSSQL();
			List classroomlist = classroom
					.getNestedListFromResultSet(sqlclassroom);
			request.setAttribute("classroom", classroomlist);
			// //从数据库中提取老师信息提交到排课页面
			String sqlteacher = "select T_ID,T_NAME from teacher";
			CConnectMSSQL teacher = new CConnectMSSQL();
			List teacherlist = teacher.getNestedListFromResultSet(sqlteacher);
			request.setAttribute("teacher", teacherlist);
			// //从数据库中提取必修课程信息提交到排课页面
			String sqllesson1 = "select L1_ID,L1_NAME from lesson1";
			CConnectMSSQL lesson1 = new CConnectMSSQL();
			List lesson1list = lesson1.getNestedListFromResultSet(sqllesson1);
			request.setAttribute("lesson1", lesson1list);
			// //从数据库中提取班级信息提交到排课页面
			String sqlclass = "select C_ID,C_NAME from class";
			CConnectMSSQL classinfo = new CConnectMSSQL();
			List classlist = classinfo.getNestedListFromResultSet(sqlclass);
			request.setAttribute("class", classlist);
			// System.out.print(list);
			request.getRequestDispatcher("MakeOneScheme.jsp").forward(request,
					response);// 转向到班级日排课提交器页面
			return;

		}
		if (("makeonelesson2listscheme".equalsIgnoreCase(action))) {
			// 从数据库中提取时间信息提交到排课页面
			String sqltime = "select TIME_ID from TIME";
			CConnectMSSQL time = new CConnectMSSQL();
			List timelist = time.getNestedListFromResultSet(sqltime);
			request.setAttribute("time", timelist);
			// System.out.print(time);
			// 从数据库中提取教室信息提交到排课页面
			String sqlclassroom = "select CR_ID,CR_NAME from CLASSROOM";
			CConnectMSSQL classroom = new CConnectMSSQL();
			List classroomlist = classroom
					.getNestedListFromResultSet(sqlclassroom);
			request.setAttribute("classroom", classroomlist);
			// //从数据库中提取老师信息提交到排课页面
			String sqlteacher = "select T_ID,T_NAME from teacher";
			CConnectMSSQL teacher = new CConnectMSSQL();
			List teacherlist = teacher.getNestedListFromResultSet(sqlteacher);
			request.setAttribute("teacher", teacherlist);
			// //从数据库中提取选修课程信息提交到排课页面
			String sqllesson1 = "select L2_ID,L2_NAME from lesson2";
			CConnectMSSQL lesson1 = new CConnectMSSQL();
			List lesson1list = lesson1.getNestedListFromResultSet(sqllesson1);
			request.setAttribute("lesson2", lesson1list);
			request.getRequestDispatcher("MakeOneLesson2ListScheme.jsp")
					.forward(request, response);// 转向到班级日排课提交器页面
			return;
		}
		//			
		if (("showlesson2listscheme".equalsIgnoreCase(action))) {
			// 从数据库中提取时间信息提交到排课页面
			String sql = "SELECT TIME.TIME_ID,L2_NAME,T_NAME,CR_NAME FROM TIME,LESSON2,TEACHER,CLASSROOM,LESSON2_LIST WHERE TIME.TIME_ID=LESSON2_LIST.TIME_ID AND LESSON2.L2_ID=LESSON2_LIST.L2_ID AND TEACHER.T_ID=LESSON2_LIST.T_ID AND CLASSROOM.CR_ID=LESSON2_LIST.CR_ID";

			CConnectMSSQL lesson2list = new CConnectMSSQL();
			List list = lesson2list.getNestedListFromResultSet(sql);
			request.setAttribute("mylist", list);
			request.getRequestDispatcher("Show_all_lesson2list.jsp").forward(
					request, response);
			return;

			// System.out.print(list);
			
		}
		if (("makeweeklesson2listscheme".equalsIgnoreCase(action))) {

			String sqlclass = "select L2_ID,L2_NAME from lesson2";
			CConnectMSSQL classinfo = new CConnectMSSQL();
			List lesson2list = classinfo.getNestedListFromResultSet(sqlclass);
			request.setAttribute("lesson2", lesson2list);
			// System.out.print(classlist);
			request.getRequestDispatcher("Lesson2SelectScheme.jsp").forward(
					request, response);
			return;
		}
		
		
		}
	}
