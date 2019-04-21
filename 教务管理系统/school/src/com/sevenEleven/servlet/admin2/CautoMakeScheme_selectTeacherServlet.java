package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.admin_test.CmakeTeacherAndCourseTogether;

/**
 * Servlet implementation class for Servlet:
 * CautoMakeScheme_selectTeacherServlet
 * 
 */
public class CautoMakeScheme_selectTeacherServlet extends
		javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CautoMakeScheme_selectTeacherServlet() {
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

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		String lesson1Name = request.getParameter("state");
		StringBuffer sb = new StringBuffer("<state>");
		CmakeTeacherAndCourseTogether ctact = new CmakeTeacherAndCourseTogether();
		try {
			List teacherNameList = ctact
					.getAllCompulsoryTeacherIdAndName(lesson1Name);

			for (int i = 0; i < teacherNameList.size(); i++) {

				sb.append("<teacher>" + teacherNameList.get(i) + "</teacher>");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sb.append("</state>");
		PrintWriter out = response.getWriter();
		out.write(sb.toString());
		out.close();

	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub response.setContentType("text/xml");
		doGet(request, response);
	}
}