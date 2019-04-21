package servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.TeacherServiceImpl;

import dao.Impl.TeacherDaoImpl;

public class ServletselectTeacherInfo extends HttpServlet{

	private TeacherServiceImpl teacherServiceImpl=new TeacherServiceImpl();

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String userNum=(String) request.getSession().getAttribute("usernum");
		List rs=teacherServiceImpl.findOne(userNum);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("teacher/editTeacherInfo.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
