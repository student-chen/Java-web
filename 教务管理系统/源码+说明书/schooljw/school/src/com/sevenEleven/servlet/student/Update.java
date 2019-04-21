package com.sevenEleven.servlet.student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sevenEleven.javaBean.student.CMethod;
import com.sevenEleven.javaBean.student.CUsMethod;

/**
 * Servlet implementation class for Servlet: Update
 * 
 */
public class Update extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Update() {
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
		String success;
		String page;
		String oldpwd = request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
		String checkpwd = request.getParameter("checkpwd");
		String userid=(String)request.getSession().getAttribute("userid");
		
		CUsMethod usmethod = new CUsMethod();
     String oldpassword=usmethod.getinformation(userid).getS_password();
		if (oldpwd.equalsIgnoreCase(oldpassword)&& newpwd.equalsIgnoreCase(checkpwd)) 
		{
			if (usmethod.Update(userid, newpwd)) 
			{   success="ÐÞ¸Ä³É¹¦!";
			   page="success.jsp";
				request.setAttribute("successMSG",success);
			    request.setAttribute("location",page);
				request.getRequestDispatcher("successpage.jsp").forward(request,
						response);
			}
		}

	}
}