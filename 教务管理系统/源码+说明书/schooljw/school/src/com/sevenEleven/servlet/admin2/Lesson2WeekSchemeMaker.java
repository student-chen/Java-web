package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CConnectMSSQL;

/**
 * Servlet implementation class for Servlet: Lesson2WeekSchemeMaker
 *
 */
 public class Lesson2WeekSchemeMaker extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Lesson2WeekSchemeMaker() {
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
		String L2_ID = request.getParameter("L2_ID");
		//System.out.print(L2_ID);
		String A0161= "SELECT CR_NAME,T_NAME,L2_NAME,TIME.TIME_ID FROM TIME,LESSON2,TEACHER,CLASSROOM,LESSON2_LIST WHERE TIME.TIME_ID=LESSON2_LIST.TIME_ID AND LESSON2.L2_ID=LESSON2_LIST.L2_ID AND TEACHER.T_ID=LESSON2_LIST.T_ID AND CLASSROOM.CR_ID=LESSON2_LIST.CR_ID AND LESSON2_LIST.TIME_ID='A016120070106' AND LESSON2_LIST.L2_ID="+L2_ID;
		CConnectMSSQL db = new CConnectMSSQL();
		List A0161LIST = db.getNestedListFromResultSet(A0161);
		request.setAttribute("A0161", A0161LIST);
		//System.out.print(A0161);
        //System.out.print(A0161LIST);
		String A0162= "SELECT CR_NAME,T_NAME,L2_NAME,TIME.TIME_ID FROM TIME,LESSON2,TEACHER,CLASSROOM,LESSON2_LIST WHERE TIME.TIME_ID=LESSON2_LIST.TIME_ID AND LESSON2.L2_ID=LESSON2_LIST.L2_ID AND TEACHER.T_ID=LESSON2_LIST.T_ID AND CLASSROOM.CR_ID=LESSON2_LIST.CR_ID AND LESSON2_LIST.TIME_ID='A016220070106' AND LESSON2_LIST.L2_ID="+L2_ID;
		CConnectMSSQL db2 = new CConnectMSSQL();
		List A0162LIST = db2.getNestedListFromResultSet(A0162);
		request.setAttribute("A0162", A0162LIST);
		//System.out.print(A0161);
        //System.out.print(A0161LIST);
		String A0163= "SELECT CR_NAME,T_NAME,L2_NAME,TIME.TIME_ID FROM TIME,LESSON2,TEACHER,CLASSROOM,LESSON2_LIST WHERE TIME.TIME_ID=LESSON2_LIST.TIME_ID AND LESSON2.L2_ID=LESSON2_LIST.L2_ID AND TEACHER.T_ID=LESSON2_LIST.T_ID AND CLASSROOM.CR_ID=LESSON2_LIST.CR_ID AND LESSON2_LIST.TIME_ID='A016320070106' AND LESSON2_LIST.L2_ID="+L2_ID;
		CConnectMSSQL db3 = new CConnectMSSQL();
		List A0163LIST = db3.getNestedListFromResultSet(A0163);
		request.setAttribute("A0163", A0163LIST);
		//System.out.print(A0161);
        //System.out.print(A0161LIST);
		String A0164= "SELECT CR_NAME,T_NAME,L2_NAME,TIME.TIME_ID FROM TIME,LESSON2,TEACHER,CLASSROOM,LESSON2_LIST WHERE TIME.TIME_ID=LESSON2_LIST.TIME_ID AND LESSON2.L2_ID=LESSON2_LIST.L2_ID AND TEACHER.T_ID=LESSON2_LIST.T_ID AND CLASSROOM.CR_ID=LESSON2_LIST.CR_ID AND LESSON2_LIST.TIME_ID='A016420070106' AND LESSON2_LIST.L2_ID="+L2_ID;
		CConnectMSSQL db4 = new CConnectMSSQL();
		List A0164LIST = db4.getNestedListFromResultSet(A0164);
		request.setAttribute("A0164", A0164LIST);
		//System.out.print(A0161);
        //System.out.print(A0161LIST);
		String A0171= "SELECT CR_NAME,T_NAME,L2_NAME,TIME.TIME_ID FROM TIME,LESSON2,TEACHER,CLASSROOM,LESSON2_LIST WHERE TIME.TIME_ID=LESSON2_LIST.TIME_ID AND LESSON2.L2_ID=LESSON2_LIST.L2_ID AND TEACHER.T_ID=LESSON2_LIST.T_ID AND CLASSROOM.CR_ID=LESSON2_LIST.CR_ID AND LESSON2_LIST.TIME_ID='A017120070107' AND LESSON2_LIST.L2_ID="+L2_ID;
		CConnectMSSQL db5 = new CConnectMSSQL();
		List A0171LIST = db5.getNestedListFromResultSet(A0171);
		request.setAttribute("A0171", A0171LIST);
		//System.out.print(A0161);
        //System.out.print(A0161LIST);
		String A0172= "SELECT CR_NAME,T_NAME,L2_NAME,TIME.TIME_ID FROM TIME,LESSON2,TEACHER,CLASSROOM,LESSON2_LIST WHERE TIME.TIME_ID=LESSON2_LIST.TIME_ID AND LESSON2.L2_ID=LESSON2_LIST.L2_ID AND TEACHER.T_ID=LESSON2_LIST.T_ID AND CLASSROOM.CR_ID=LESSON2_LIST.CR_ID AND LESSON2_LIST.TIME_ID='A017220070107' AND LESSON2_LIST.L2_ID="+L2_ID;
		CConnectMSSQL db6 = new CConnectMSSQL();
		List A0172LIST = db6.getNestedListFromResultSet(A0172);
		request.setAttribute("A0172", A0172LIST);
		//System.out.print(A0161);
        //System.out.print(A0161LIST);
		String A0173= "SELECT CR_NAME,T_NAME,L2_NAME,TIME.TIME_ID FROM TIME,LESSON2,TEACHER,CLASSROOM,LESSON2_LIST WHERE TIME.TIME_ID=LESSON2_LIST.TIME_ID AND LESSON2.L2_ID=LESSON2_LIST.L2_ID AND TEACHER.T_ID=LESSON2_LIST.T_ID AND CLASSROOM.CR_ID=LESSON2_LIST.CR_ID AND LESSON2_LIST.TIME_ID='A017320070107' AND LESSON2_LIST.L2_ID="+L2_ID;
		CConnectMSSQL db7 = new CConnectMSSQL();
		List A0173LIST = db7.getNestedListFromResultSet(A0173);
		request.setAttribute("A0173", A0173LIST);
		//System.out.print(A0161);
        //System.out.print(A0161LIST);
		String A0174= "SELECT CR_NAME,T_NAME,L2_NAME,TIME.TIME_ID FROM TIME,LESSON2,TEACHER,CLASSROOM,LESSON2_LIST WHERE TIME.TIME_ID=LESSON2_LIST.TIME_ID AND LESSON2.L2_ID=LESSON2_LIST.L2_ID AND TEACHER.T_ID=LESSON2_LIST.T_ID AND CLASSROOM.CR_ID=LESSON2_LIST.CR_ID AND LESSON2_LIST.TIME_ID='A017420070107' AND LESSON2_LIST.L2_ID="+L2_ID;
		CConnectMSSQL db8 = new CConnectMSSQL();
		List A0174LIST = db8.getNestedListFromResultSet(A0174);
		request.setAttribute("A0174", A0174LIST);
		//System.out.print(A0161);
        //System.out.print(A0161LIST);
		
		request.getRequestDispatcher("find_one_lesson2_scheme_in_all.jsp").forward(request,
				response);	
		
		
	}   	  	    
}