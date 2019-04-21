package msc.slt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import msc.dao.*;
import msc.vo.Student;

public class student_slt extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    String action = request.getParameter("action");
	   
	    if ("new".equalsIgnoreCase(action)) {
	    	doAdd(request,response);
	    	
	    } 
	    if("delete".equalsIgnoreCase(action)){
	    	doDelete(request,response);
	    	
	    }
	    if("update".equalsIgnoreCase(action)){
				doUpdate(request,response);
				
	    }
	
 }
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	     throws ServletException, IOException {
		doPost(request,response);
    
    }
	
	public void doAdd(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String smajor=request.getParameter("smajor");
		String sclass=request.getParameter("sclass");
		String scode=request.getParameter("scode");
		
		StudentDAO sdao=new StudentDAO();
		UserDAO udao=new UserDAO();
		try {
			sdao.InsertStudent(sid, sname, smajor, sclass, scode);
			udao.InsertUser(sid, sname, scode, "student");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/t.png ><font size=6 color=red>  Ìí¼Ó³É¹¦£¡</font> ");
			out.println("  </BODY>");
			out.println("</HTML>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/f.png ><font size=6 color=red>  Ìí¼ÓÊ§°Ü£¡</font> ");
			out.println("  </BODY>");
			out.println("</HTML>");
			
		}
		out.flush();
		out.close();

   }
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		response.setContentType("text/html");
	    request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    String sid=request.getParameter("sid");

	    StudentDAO sdao=new StudentDAO();
	    UserDAO udao=new UserDAO();
	     try {
		     sdao.DeletebyID(sid);
		     udao.DeletebyID(sid);
		     out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		     out.println("<HTML>");
		     out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		     out.println("  <BODY bgcolor=#8dd8f8>");
		     out.print("  <img src=image/t.png ><font size=6 color=red>  É¾³ý³É¹¦£¡</font> ");
		     out.println("  </BODY>");
		     out.println("</HTML>");
		
	        } catch (Exception e) {
		// TODO Auto-generated catch block
	    	out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
	    	out.println("<HTML>");
	    	out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
	    	out.println("  <BODY bgcolor=#8dd8f8>");
	    	out.print("  <img src=image/f.png ><font size=6 color=red>  É¾³ýÊ§°Ü£¡</font> ");
	    	out.println("  </BODY>");
	    	out.println("</HTML>");
		
	        }
	        out.flush();
	        out.close();
	}
	public void doUpdate(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		response.setContentType("text/html");
	    request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    String sid=request.getParameter("sid");
	    String sname=request.getParameter("sname");
	    String sclass=request.getParameter("sclass");
	    String smajor=request.getParameter("smajor");
	    String scode=request.getParameter("scode");
	    UserDAO udao=new UserDAO();
	   StudentDAO sdao=new StudentDAO();
	   try {
		sdao.UpdatebyID(sid, sname, smajor, sclass, scode);
		udao.UpdatebyID(sid, sname, scode, "student");
		out.println("<HTML>");
	     out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
	     out.println("  <BODY bgcolor=#8dd8f8>");
	     out.print("  <img src=image/t.png ><font size=6 color=red>  ÐÞ¸Ä³É¹¦£¡</font> ");
	     out.println("  </BODY>");
	     out.println("</HTML>");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		out.println("<HTML>");
	     out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
	     out.println("  <BODY bgcolor=#8dd8f8>");
	     out.print("  <img src=image/f.png ><font size=6 color=red>ÐÞ¸ÄÊ§°Ü£¡</font> ");
	     out.println("  </BODY>");
	     out.println("</HTML>");
	}
	out.flush();
	out.close();

	}

}
