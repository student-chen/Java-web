package servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.Impl.StudentServiceImpl;
import servlet.ServletFindAllStu;
import dao.Impl.StudentDaoImpl;

public class ServletSelectStudentInfo extends HttpServlet{
	
	private Student student;
	private StudentServiceImpl studentServiceImpl=new StudentServiceImpl();
	private ServletFindAllStu findStu=new ServletFindAllStu();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String stuNum=(String) request.getSession().getAttribute("usernum");
		List rs=studentServiceImpl.findOne(stuNum);
		
		request.setAttribute("list", rs);
		request.getRequestDispatcher("student/editStudentInfo.jsp").forward(request, response);
	
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
