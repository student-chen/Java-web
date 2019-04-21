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

public class ServletDeleteCos extends HttpServlet{

	private Course course;
	private ServletFindAllCos servletFindAllCos=new ServletFindAllCos();
	private CourseServiceImpl courseServiceImpl=new CourseServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int courseID = Integer.parseInt(request.getParameter("courseID"));
	
		int rs=courseServiceImpl.deleteCos(courseID);
		if(rs>0){
			request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
			servletFindAllCos.doGet(request, response);
			//	request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
			servletFindAllCos.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
