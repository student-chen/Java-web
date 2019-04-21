package com.sevenEleven.servlet.admin2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CDBOracle;

/**
 * Servlet implementation class for Servlet: DaySchemeMaker
 *
 */
 public class DaySchemeMaker extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public DaySchemeMaker() {
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
		String CID = request.getParameter("cname");
		
		String TIMEID1 = request.getParameter("time1");
		String TIMEID2 = request.getParameter("time2");
		String TIMEID3 = request.getParameter("time3");
		String TIMEID4 = request.getParameter("time4");
		
		String L1ID1 = request.getParameter("lesson11");
		String L1ID2 = request.getParameter("lesson12");
		String L1ID3 = request.getParameter("lesson13");
		String L1ID4 = request.getParameter("lesson14");
		
		String TID1 = request.getParameter("teacher1");
		String TID2 = request.getParameter("teacher2");
		String TID3 = request.getParameter("teacher3");
		String TID4 = request.getParameter("teacher4");
		
		String CRID1 = request.getParameter("classroom1");
		String CRID2 = request.getParameter("classroom2");
		String CRID3 = request.getParameter("classroom3");
		String CRID4 = request.getParameter("classroom4");
		
		//System.out.print(userName);
		//System.out.print(name);
		//System.out.print(password);
		//System.out.print(password2);
		//System.out.print(cname);
//		String sql = "insert into student vaules (seq_student_p.nextval,"+cname+",'"+name+"','"+userName+"','"+password+"')";     
		  String sql1 = "insert into lesson1_list values ("+CID+","+TID1+","+CRID1+","+L1ID1+",'"+TIMEID1+"')"; 
		  String sql2 = "insert into lesson1_list values ("+CID+","+TID2+","+CRID2+","+L1ID2+",'"+TIMEID2+"')"; 
		  String sql3 = "insert into lesson1_list values ("+CID+","+TID3+","+CRID3+","+L1ID3+",'"+TIMEID3+"')"; 
		  String sql4 = "insert into lesson1_list values ("+CID+","+TID4+","+CRID4+","+L1ID4+",'"+TIMEID4+"')"; 
		  
			//CConnectMSSQL db = new CConnectMSSQL();
		
		//System.out.print(sql1);
		//System.out.print(sql2);
		//System.out.print(sql3);
		//System.out.print(sql4);
		CDBOracle db = new CDBOracle();

		db.executeUpdate(sql1);
		db.executeUpdate(sql2);
		db.executeUpdate(sql3);
		db.executeUpdate(sql4);
	    db.execute("commit");
		//System.out.print("success!!!!??");
			
		//request.getRequestDispatcher("show_all_student.jsp").forward(
					//request, response);
	    response.sendRedirect("info_admin.jsp");
	}   	  	    
}