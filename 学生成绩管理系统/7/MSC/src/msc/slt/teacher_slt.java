package msc.slt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import msc.dao.ScDAO;
import msc.dao.StudentDAO;
import msc.dao.TeacherDAO;
import msc.dao.UserDAO;

public class teacher_slt extends HttpServlet {
	boolean flag;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    String action = request.getParameter("action");
	   
	    if ("new".equalsIgnoreCase(action)) {
	    	doAdd(request,response);
	    	flag=true;
	    } 
	    if("delete".equalsIgnoreCase(action)){
	    	doDelete(request,response);
	    	flag=true;
	    }
	    if("update".equalsIgnoreCase(action)){
			doUpdate(request,response);
			flag=true;	
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
		
		String tid=request.getParameter("tid");
		String tname=request.getParameter("tname");
		String tcode=request.getParameter("tcode");
		
		TeacherDAO tdao=new TeacherDAO();
		UserDAO udao=new UserDAO();
		try {
			tdao.InsertTeacher(tid, tname,tcode);
			udao.InsertUser(tid, tname, tcode, "teacher");
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
	
	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
	    request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    String tid=request.getParameter("tid");

	    TeacherDAO tdao=new TeacherDAO();
	    UserDAO udao=new UserDAO();
	    ScDAO scdao=new ScDAO();
	     try {
		     tdao.DeletebyID(tid);
		     udao.DeletebyID(tid);
		     scdao.DeletebyTID(tid);
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
	    String tid=request.getParameter("tid");
	    String tname=request.getParameter("tname");
	    String tcode=request.getParameter("tcode");
	    UserDAO udao=new UserDAO();
	   TeacherDAO sdao=new TeacherDAO();
	   try {
		sdao.UpdatebyID(tid, tname, tcode);
		udao.UpdatebyID(tid, tname, tcode, "kind");
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


	
	public void init() throws ServletException {
		// Put your code here
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

}
