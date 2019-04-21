package com.sevenEleven.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.Beans.CstudentBean;
import com.sevenEleven.javaBean.student.CUsMethod;

/**
 * Servlet implementation class for Servlet: Cstudent_updateInfoServlet
 *
 */
 public class Cstudent_updateInfoServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Cstudent_updateInfoServlet() {
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
		 CstudentBean student = new CstudentBean();
			Object userid=((CstudentBean)request.getSession().getAttribute("student")).getS_number();
			CUsMethod usmethod=new CUsMethod();
			  student=usmethod.getinformation(userid);
		          
			     String c_name= usmethod.getinformation(userid).getC_name();
			   Object c_id= usmethod.getinformation(userid).getC_id();
			 String pwd=  usmethod.getinformation(userid).getS_password();
			 String c_type=  usmethod.getinformation(userid).getC_type();
			 String s_num= usmethod.getinformation(userid).getS_number();
			 request.setAttribute("c_name",c_name);
			 request.setAttribute("c_id",c_id);
			 request.setAttribute("pwd",pwd);
			 request.setAttribute("c_type",c_type);
			 request.setAttribute("s_num",s_num);
				request.getRequestDispatcher("update.jsp").forward(request,response);
		
	}   	  	    
}