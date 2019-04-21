package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.admin_test.CmakeTeacherAndCourseTogether;

/**
 * Servlet implementation class for Servlet:
 * CautoMakeScheme_getLesson1AndTeacherInfo
 * 
 */
public class CautoMakeScheme_getLesson1AndTeacherInfo extends
		javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CautoMakeScheme_getLesson1AndTeacherInfo() {
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
		CmakeTeacherAndCourseTogether mtact = new CmakeTeacherAndCourseTogether();
		String className = (String) request.getSession()
				.getAttribute("className");
		String phase = (String) request.getSession().getAttribute("phase");
		//得到State和teacher再放到Parameter里去
		String lesson1Name = (String) request.getParameter("state");
		String teacherName = (String) request.getParameter("teacher");
		
		//
		String lesson1Id = null;
		String classId = null;
		String warnMessage = new String();      //报错变量
//		 由className得到classId
		if ((className == null) || (className == "")) {
            request.getSession().setAttribute("warnMessage","课程名不能为空!!");
            request.getRequestDispatcher("CautoMakeScheme_printCheckedClassAndPhase").forward(request, response);
            return;
	} else {

		try {
			classId = mtact
					.getClassIdFromClassName(className);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		// 由lesson1Name得到lesson1Id
		if ((lesson1Name == null) || (lesson1Name == "")) {
                   request.getSession().setAttribute("warnMessage","课程名不能为空!!");
                   request.getRequestDispatcher("CautoMakeScheme_printCheckedClassAndPhase").forward(request, response);
                   return;
		} else {

			try {
				 lesson1Id = mtact
						.getLesson1IdFromLesson1Name(lesson1Name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
       // 由teacherName 得到teacher id
		String teacherId = null;
		if ((teacherName == null) || (teacherName == "")) {
			 request.getSession().setAttribute("warnMessage","老师名不能为空!!");
             request.getRequestDispatcher("CautoMakeScheme_printCheckedClassAndPhase").forward(request, response);
             return;
		} else {

			try {
				 teacherId = mtact
						.getTeacherIdFromTeacherName(teacherName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 判断数据是否已存在.存在就返回存在信息,不存在则插入数据  
		if(mtact.checkTableTeacherAndLesson1ForClass(classId,lesson1Id,teacherId)){
			request.getSession().setAttribute("warnMessage","课程已被安排!!");
			request.getRequestDispatcher("CautoMakeScheme_printCheckedClassAndPhase").forward(request, response);
			return;
		}else{
			warnMessage = mtact.insertIntoTableTeacherAndLesson1ForClass(teacherId, lesson1Id, classId,phase)?("插入成功"):("插入失败");
			request.getSession().setAttribute("warnMessage",warnMessage);
			request.getRequestDispatcher("CautoMakeScheme_printCheckedClassAndPhase").forward(request, response);
			return;
		}

	}
}