package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.CourseServiceImpl;

import model.Course;
import dao.Impl.CourseDaoImpl;

public class ServletEditCos extends HttpServlet{

	private Course course;
	private ServletFindAllCos servletFindAllCos=new ServletFindAllCos();
	private ServletSelectCos selectOne=new ServletSelectCos();
	private CourseServiceImpl courseServiceImpl=new CourseServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int courseID=Integer.parseInt(request.getParameter("courseID"));
		String courseName = request.getParameter("courseName");
		int courseCredit = Integer.parseInt(request.getParameter("courseCredit"));
		int courseHours = Integer.parseInt(request.getParameter("courseHours"));
		String courseTea = request.getParameter("courseTea");
		String coDate = request.getParameter("courseDate");
		Date courseDate = null;
		try {
			 courseDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("courseDate"));
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 

		course=new Course(courseID,courseName,courseCredit,courseHours,courseTea,courseDate);
		int rs=courseServiceImpl.editCos(course,coDate);
		if(rs>0){
			request.setAttribute("msg", "修改成功！！");
			servletFindAllCos.doGet(request, response);
			//	request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "修改失败！！");
			selectOne.doGet(request, response);
			//request.getRequestDispatcher("admin/editCourse.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
