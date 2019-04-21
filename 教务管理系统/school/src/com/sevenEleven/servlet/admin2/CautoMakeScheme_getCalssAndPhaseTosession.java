package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: CautoMakeScheme_getCalssAndPhaseTosession
 *
 */
 public class CautoMakeScheme_getCalssAndPhaseTosession extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public CautoMakeScheme_getCalssAndPhaseTosession() {
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
		String className = request.getParameter("class");
		String phase = request.getParameter("phase");
		request.getSession().setAttribute("className",className);
		request.getSession().setAttribute("phase",phase);
		request.getRequestDispatcher("CautoMakeScheme_printCheckedClassAndPhase").forward(request, response);
	}   	  	    
}