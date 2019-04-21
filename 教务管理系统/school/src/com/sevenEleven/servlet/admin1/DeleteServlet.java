package com.sevenEleven.servlet.admin1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sevenEleven.javaBean.CDBConnection;

/**
 * Servlet implementation class for Servlet: DeleteServlet
 *
 */
 public class DeleteServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
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
		//删除管理员，从数据库中删掉一列
		PrintWriter out = response.getWriter();
		String a_id = request.getParameter("aid");
		//System.out.print(SID);
		String sql = "delete from administrator where a_id="+a_id;
		//System.out.print(sql);
		CDBConnection db = new CDBConnection();
		db.executeUpdate(sql);
		db.execute("commit");
	
		//response.sendRedirect("info_admin.jsp");
		out.print("<script language=javascript>alert('Delelte Success!');this.location.href='info_admin_systerm.jsp'</script>");
		
	}   	  	    
}