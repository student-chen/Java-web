package com.sevenEleven.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sevenEleven.Beans.CteacherBean;
import com.sevenEleven.javaBean.teacher.DBO;
import com.sevenEleven.javaBean.teacher.Doing;

 public class UpdateTeacherInfo extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	private static final long serialVersionUID = 1L;
	public UpdateTeacherInfo() {
		super();
	}   	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String userID=String.valueOf(((CteacherBean)session.getAttribute("teacher")).getT_id());
		if (userID==null||userID==""){
			request.setAttribute("errorMSG","没有登陆或登陆已超时");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		String teacherNAME=request.getParameter("teacherNAME");
		String teacherPWD=request.getParameter("teacherPWD");
		if (teacherNAME==null||teacherPWD==null||teacherNAME==""||teacherPWD==""){
			request.setAttribute("errorMSG","用户名密码不能为空");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		Doing DB=DBO.DBODoing();
		if (DB.UpdateTeacherInfo(userID,teacherNAME,teacherPWD)){
			DB.Close();
			request.setAttribute("successMSG","更新资料成功");
			request.setAttribute("location","Teacher.jsp");
			request.getRequestDispatcher("success.jsp").forward(request,response);
			return;
		}else{
			DB.Close();
			request.setAttribute("errorMSG","更新资料失败,确认数据是否合法");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}   	  	    
}