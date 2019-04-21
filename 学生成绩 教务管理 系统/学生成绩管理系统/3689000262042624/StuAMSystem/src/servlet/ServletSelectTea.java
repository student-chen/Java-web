package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.TeacherServiceImpl;

import model.Teacher;

import dao.Impl.TeacherDaoImpl;


public class ServletSelectTea extends HttpServlet{

	private Teacher teacher;
	private TeacherServiceImpl teacherServiceImpl=new TeacherServiceImpl();
	private ServletFindAllTea findTea=new ServletFindAllTea();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String teaNum=request.getParameter("teanum");
		List rs=teacherServiceImpl.findOne(teaNum);
		
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editTeacher.jsp").forward(request, response);
	
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
