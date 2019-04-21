package com.sevenEleven.servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sevenEleven.Beans.CteacherBean;
import com.sevenEleven.javaBean.teacher.DBO;
import com.sevenEleven.javaBean.teacher.Doing;
import com.sevenEleven.javaBean.teacher.Typer;

 public class StuResult extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	public StuResult() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String teacherID=String.valueOf(((CteacherBean)session.getAttribute("teacher")).getT_id());
		if (teacherID==null||teacherID==""){
			request.setAttribute("errorMSG","没有登陆或登陆已超时");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		String s_id=request.getParameter("s_id");
		if (s_id==null||s_id==""||!Typer.IsInter(s_id)){
			request.setAttribute("errorMSG","数据不合法");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			return;
		}
		Doing DB=DBO.DBODoing();
		if (DB.IsTeacherStu(teacherID,s_id)){
			request.setAttribute("StudentResult",DB.GetStuResult(s_id,teacherID));
			request.getRequestDispatcher("ShowStudentResult.jsp").forward(request,response);
			DB.Close();
			return;
			
		}else{
			request.setAttribute("errorMSG","此学生不是你的学生");
			request.getRequestDispatcher("error.jsp").forward(request,response);
			DB.Close();
			return;
		}
	}  	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}   	  	    
}