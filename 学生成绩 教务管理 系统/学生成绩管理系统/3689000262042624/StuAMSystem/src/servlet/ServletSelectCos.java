package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.CourseServiceImpl;

import model.Course;
import dao.Impl.CourseDaoImpl;

public class ServletSelectCos extends HttpServlet{

	private Course course;
	private ServletFindAllCos servletFindAllCos=new ServletFindAllCos();
	private CourseServiceImpl courseServiceImpl=new CourseServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int courseID = Integer.parseInt(request.getParameter("courseID"));
	
		List rs=courseServiceImpl.findOne(courseID);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editCourse.jsp").forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
