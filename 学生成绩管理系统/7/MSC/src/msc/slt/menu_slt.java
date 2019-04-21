package msc.slt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import msc.dao.*;
import msc.vo.*;

public class menu_slt extends HttpServlet {

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		if ("changecode".equalsIgnoreCase(action)) {
			doChangecode(request,response);
			
		} 
		if("quit".equalsIgnoreCase(action)){
			doQuit(request,response);
		}
	}

	
	public void doChangecode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String id=request.getParameter("id");
		String kind=request.getParameter("kind");
		String oldpa=request.getParameter("oldpa");
		String newpa=request.getParameter("newpa");
		String confpa=request.getParameter("confpa");
		UserDAO udao=new UserDAO();
		User user=new User();
		try {
			user=(User) udao.check(id,kind);
			if(oldpa.equals(user.getCode())){
				if(newpa.equals(confpa)){
					if(kind.equals("admin")){
						udao.Changecode(id, newpa);
						out.println("  <BODY bgcolor=#8dd8f8>");
						out.print("  <img src=image/t.png ><font size=6 color=red>  密码修改成功！</font> ");
						out.println("  </BODY>");
					}
					else if(kind.equals("teacher")){
						udao.Changecode(id, newpa);
						TeacherDAO tdao=new TeacherDAO();
						tdao.Changecode(id, newpa);
						out.println("  <BODY bgcolor=#8dd8f8>");
						out.print("  <img src=image/t.png ><font size=6 color=red>  密码修改成功！</font> ");
						out.println("  </BODY>");
					}
					else{
						udao.Changecode(id, newpa);
						StudentDAO sdao=new StudentDAO();
						sdao.Changecode(id, newpa);
						out.println("  <BODY bgcolor=#8dd8f8>");
						out.print("  <img src=image/t.png ><font size=6 color=red>  密码修改成功！</font> ");
						out.println("  </BODY>");
					}
				}
				else{
					out.println("  <BODY bgcolor=#8dd8f8>");
					out.print("  <img src=image/f.png ><font size=6 color=red>  两次密码输入不一致！！！</font> ");
					out.println("  </BODY>");
				}
			}
			else{
				out.println("  <BODY bgcolor=#8dd8f8>");
				out.print("  <img src=image/f.png ><font size=6 color=red>  原密码错误！！！</font> ");
				out.println("  </BODY>");
			}
			
		} catch (Exception e) {
			out.println("<img src=image/f.png >修改出错！！！");
		}
		out.flush();
		out.close();
	}
	public void doQuit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(true);
        session.invalidate();
        response.sendRedirect("login.jsp");
	}
	

	public void init() throws ServletException {
		// Put your code here
	}

}
