package msc.slt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import msc.dao.*;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;



public class jxl_slt extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	    String action = request.getParameter("action");
	    if ("newcourse".equalsIgnoreCase(action)) {
	    	
	    	doAddCourse(request,response);
	    } 
	    
	    if("newstudent".equalsIgnoreCase(action)){
	    	doAddStudent(request,response);
	    	
	    }
	    if("newteacher".equalsIgnoreCase(action)){
	    	doAddTeacher(request,response);
				
	    }
	    if("subsc".equalsIgnoreCase(action)){
	    	doSubScore(request,response);
        }
	}

	public void doAddCourse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	    String filepath=request.getParameter("filepath");
	    CourseDAO cdao=new CourseDAO();
	    
		try {
    		
			Workbook book = Workbook.getWorkbook(new File(filepath));
			
			Sheet sheet = book.getSheet(0);	
			
			int total=sheet.getRows();
			
			for(int i=1;i<total;i++){
				Cell cell = sheet.getCell(0,i);
	        	String cno=new String();
	        	cno = cell.getContents();
	        	
	        	Cell cell1=sheet.getCell(1,i);
	        	String cname=new String();
	        	cname=cell1.getContents();
	        	
	        	Cell cell2=sheet.getCell(2,i);
	        	double credit=Double.parseDouble(cell2.getContents());
	        	try{
	        		cdao.InsertCourse(cno, cname, credit);
	        	}catch (Exception e){
	    			
	    		}
	        	
			}
			book.close();
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/t.png ><font size=6 color=red>导入成功!<br> 共计 "+total+"条记录</font> ");
			out.println("  </BODY>");
			out.println("</HTML>");
		}catch (Exception e){
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/f.png ><font size=6 color=red> 读取出错！！！</font> ");
			out.println("  </BODY>");
			out.println("</HTML>");
			
		}
		
		out.flush();
		out.close();

		// Put your code here
	}
	public void doAddStudent(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	    String filepath=request.getParameter("filepath");
	    StudentDAO sdao=new StudentDAO();
	    UserDAO udao=new UserDAO();
		try {
    		
			Workbook book = Workbook.getWorkbook(new File(filepath));
			
			Sheet sheet = book.getSheet(0);	
			
			int total=sheet.getRows();
			
			for(int i=1;i<total;i++){
				Cell cell = sheet.getCell(0,i);
	        	String sid= cell.getContents();
	        	
	        	Cell cell1=sheet.getCell(1,i);
	        	String sname=cell1.getContents();
	        	Cell cell2=sheet.getCell(2, i);
	        	String smajor=cell2.getContents();
	        	Cell cell3=sheet.getCell(3, i);
	        	String sclass=cell3.getContents();
	        	Cell cell4=sheet.getCell(4, i);
	        	String scode=cell4.getContents();
	        	
	        	try{
	        		sdao.InsertStudent(sid, sname, smajor, sclass, scode);
	        		udao.InsertUser(sid, sname, scode, "student");
	        		
	        	}catch (Exception e){
	    		
	    		}
			}
			book.close();
			
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/t.png ><font size=6 color=red>导入成功!<br> 共计 "+total+"条记录</font> ");
			out.println("  </BODY>");
			out.println("</HTML>");
		
		}catch (Exception e){
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/f.png ><font size=6 color=red> 读取出错！！！</font> ");
			out.println("  </BODY>");
			out.println("</HTML>");
			
		}
			
		
		out.flush();
		out.close();

		// Put your code here
	}
	public void doAddTeacher(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
	    String filepath=request.getParameter("filepath");
	    TeacherDAO tdao=new TeacherDAO();
	    UserDAO udao=new UserDAO();
		try {
    		
			Workbook book = Workbook.getWorkbook(new File(filepath));
			
			Sheet sheet = book.getSheet(0);	
			
			int total=sheet.getRows();
			
			for(int i=1;i<total;i++){
				Cell cell = sheet.getCell(0,i);
	        	String tid= cell.getContents();
	        	
	        	Cell cell1=sheet.getCell(1,i);
	        	String tname=cell1.getContents();
	        	
	        	Cell cell4=sheet.getCell(2, i);
	        	String tcode=cell4.getContents();	        	
	        	try{
	        		tdao.InsertTeacher(tid, tname, tcode);
	        		udao.InsertUser(tid, tname, tcode, "teacher");	        		
	        	}catch (Exception e){	    				    		
	    		}
			}
			book.close();
			
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/t.png ><font size=6 color=red>导入成功!<br> 共计 "+total+"条记录</font> ");
			out.println("  </BODY>");
			out.println("</HTML>");		
		}catch (Exception e){
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/f.png ><font size=6 color=red> 读取出错！！！</font> ");
			out.println("  </BODY>");
			out.println("</HTML>");			
		}			
		out.flush();
		out.close();

		// Put your code here
	}
	public void doSubScore(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String tid=request.getParameter("tid");
		String cno=request.getParameter("cno");
	    String filepath=request.getParameter("filepath");
	    
		try { 		
			Workbook book = Workbook.getWorkbook(new File(filepath));
			
			Sheet sheet = book.getSheet(0);	
			
			int total=sheet.getRows();
			ScDAO scdao=new ScDAO();
			TcDAO tcdao=new TcDAO();
			for(int i=1;i<total;i++){
				Cell cell = sheet.getCell(0,i);
	        	String sid= cell.getContents();
	        	
	        	Cell cell1=sheet.getCell(2,i);
	        	String rpscore=cell1.getContents();
	        	double pscore=Double.parseDouble(rpscore);
	        	Cell cell2=sheet.getCell(3, i);
	        	String rlscore=cell2.getContents();
	        	double lscore=Double.parseDouble(rlscore);
	        	try{
	        		scdao.UpdateScore(sid, cno,tid, pscore, lscore);
	        		
	        	}catch (Exception e){    		
	    		}
			}
			book.close();
			tcdao.UpdateSub(tid, cno, "1");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/t.png ><font size=6 color=red>导入成功!<br> 共计 "+total+"条记录</font> ");
			out.println("  </BODY>");
			out.println("</HTML>");		
		}catch (Exception e){
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY bgcolor=#8dd8f8>");
			out.print("  <img src=image/f.png ><font size=6 color=red> 读取出错！！！</font> ");
			out.println("  </BODY>");
			out.println("</HTML>");			
		}			
		out.flush();
		out.close();

		// Put your code here
	}

}
