package servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.Impl.StudentServiceImpl;
import servlet.ServletFindAllStu;
import dao.Impl.StudentDaoImpl;

public class ServletEditStudentInfo extends HttpServlet{
	
	private Student student;
	private StudentServiceImpl studentServiceImpl=new StudentServiceImpl();
	private ServletSelectStudentInfo findStu=new ServletSelectStudentInfo();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String stuNum=request.getParameter("stuNum");
		String stuName = request.getParameter("stuName");
		String stuSex = request.getParameter("stuSex");
		int stuAge = Integer.parseInt(request.getParameter("stuAge"));
		String stuClass = request.getParameter("stuClass");
		String major = request.getParameter("major");
		String department = request.getParameter("department");
		student = new Student(stuNum, stuName, stuSex, stuAge, stuClass, major,
				department);
		int rs=studentServiceImpl.editStu(student);
		if(rs>0){
			request.setAttribute("msg", "修改成功！！");
			findStu.doGet(request, response);
		}else{
			request.setAttribute("msg", "修改失败！！");
			request.getRequestDispatcher("student/editStudentInfo.jsp").forward(request, response);
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}
}
