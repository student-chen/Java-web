package msc.slt;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import msc.vo.*;
import msc.dao.*;
public class login_conf extends HttpServlet {

	
	public login_conf() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String kind=request.getParameter("kind");
		
//		Date now = new Date(System.currentTimeMillis()); 
//		DateFormat date = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); 
//		String nowtime = date.format(now);
//		System.out.println("()()()()))");

		UserDAO udao=new UserDAO();
		User user=null;
		try {
			user=udao.check(id,kind);
//			System.out.println("&&&&&&&&&&&&&&&");

			if(user.getId().equals(id)){
				HttpSession session;
				session=request.getSession(true); 
				session.setAttribute("id",user.getId());
				session.setAttribute("na",user.getName());
				session.setAttribute("pa",user.getCode());
				session.setAttribute("kind",user.getKind());
				if(kind.equals("admin")){
					if(password.equals(user.getCode())){
//						System.out.println(nowtime);

						response.sendRedirect("admin_frame.jsp");
					}
					else{
				        response.setHeader("refresh","2;URL=login.jsp") ;
					    out.print("<font size=5 color=red>ÃÜÂë´íÎó£¡ÇëÖØĞÂµÇÂ¼......</font>");
					}
				}
				else if(kind.equals("student")){
					if(password.equals(user.getCode())){
						response.sendRedirect("student_frame.jsp");
					}
					else{
						
						response.setHeader("refresh","2;URL=login.jsp") ;
						out.print("<font size=5 color=red>ÃÜÂë´íÎó£¡ÇëÖØĞÂµÇÂ¼......</font>");
					}
				}
				else if(kind.equals("teacher")){
					if(password.equals(user.getCode())){
						response.sendRedirect("teacher_frame.jsp");
					}
					else{
						response.setHeader("refresh","2;URL=login.jsp") ;
						out.print("<font size=5 color=red>ÃÜÂë´íÎó£¡ÇëÖØĞÂµÇÂ¼......</font>");
					}
				}
			}
		} catch (Exception e) {
			response.setHeader("refresh","2;URL=login.jsp") ;
			out.print("<font size=5 color=red>ÓÃ»§"); 
			out.print(id);
			out.print("²»´æÔÚ£¡ÇëÖØĞÂµÇÂ¼......</font>");
		}
		out.flush();
		out.close();
	}

}
