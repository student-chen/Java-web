package com.sevenEleven.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sevenEleven.Beans.CstudentBean;
import com.sevenEleven.javaBean.student.CUsMethod;

/**
 * Servlet implementation class for Servlet: PersonalL2Info
 *
 */
 public class PersonalL2Info extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public PersonalL2Info() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CUsMethod usmethod=new CUsMethod();
		Object userid=((CstudentBean)request.getSession().getAttribute("student")).getS_number();
		List list=usmethod.GetPersonalL2Info(userid);
		request.setAttribute("info",list);
		request.getRequestDispatcher("personall2.jsp").forward(request,response);
		
	}   	  	    
}