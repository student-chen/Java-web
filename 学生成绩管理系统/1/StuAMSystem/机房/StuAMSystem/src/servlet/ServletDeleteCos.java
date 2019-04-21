package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import service.Impl.CourseServiceImpl;

public class ServletDeleteCos extends HttpServlet{

	private Course course;
	private ServletFindAllCos servletFindAllCos=new ServletFindAllCos();
	private CourseServiceImpl courseServiceImpl=new CourseServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int courseID = Integer.parseInt(request.getParameter("courseID"));
	
		int rs=courseServiceImpl.deleteCos(courseID);
		if(rs>0){
			request.setAttribute("msg", "删除成功！！");
			servletFindAllCos.doGet(request, response);
			//	request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "删除失败！！");
			servletFindAllCos.doGet(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
